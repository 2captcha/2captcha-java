package com.twocaptcha;

import com.twocaptcha.captcha.Captcha;
import com.twocaptcha.captcha.ReCaptcha;
import com.twocaptcha.exceptions.ApiException;
import com.twocaptcha.exceptions.NetworkException;
import com.twocaptcha.exceptions.TimeoutException;
import com.twocaptcha.exceptions.ValidationException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Class TwoCaptcha
 */
public class TwoCaptcha {

    /**
     * API KEY
     */
    private String apiKey;

    /**
     * ID of software developer. Developers who integrated their software
     * with our service get reward: 10% of spendings of their software users.
     */
    private int softId = 4581;

    /**
     * URL to which the result will be sent
     */
    private String callback;

    /**
     * How long should wait for captcha result (in seconds)
     */
    private int defaultTimeout = 120;

    /**
     * How long should wait for recaptcha result (in seconds)
     */
    private int recaptchaTimeout = 600;

    /**
     * How often do requests to `/res.php` should be made
     * in order to check if a result is ready (in seconds)
     */
    private int pollingInterval = 10;

    /**
     * Helps to understand if there is need of waiting
     * for result or not (because callback was used)
     */
    private boolean lastCaptchaHasCallback;

    /**
     * Network client
     */
    private ApiClient apiClient;

    /**
     * TwoCaptcha constructor
     */
    public TwoCaptcha() {
        this.apiClient = new ApiClient();
    }

    /**
     * TwoCaptcha constructor
     *
     * @param apiKey
     */
    public TwoCaptcha(String apiKey) {
        this();
        setApiKey(apiKey);
    }

    /**
     * @param apiKey
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * @param domain
     */
    public void setHost(String domain) {
        this.apiClient.setHost(domain);
    }


    /**
     * @param softId
     */
    public void setSoftId(int softId) {
        this.softId = softId;
    }

    /**
     * @param callback
     */
    public void setCallback(String callback) {
        this.callback = callback;
    }

    /**
     * @param timeout
     */
    public void setDefaultTimeout(int timeout) {
        this.defaultTimeout = timeout;
    }

    /**
     * @param timeout
     */
    public void setRecaptchaTimeout(int timeout) {
        this.recaptchaTimeout = timeout;
    }

    /**
     * @param interval
     */
    public void setPollingInterval(int interval) {
        this.pollingInterval = interval;
    }

    /**
     * @param apiClient
     */
    public void setHttpClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Sends captcha to `/in.php` and waits for it's result.
     * This helper can be used instead of manual using of `send` and `getResult` functions.
     *
     * @param captcha
     * @throws Exception
     */
    public void solve(Captcha captcha) throws Exception {
        Map<String, Integer> waitOptions = new HashMap<>();

        if (captcha instanceof ReCaptcha) {
            waitOptions.put("timeout", recaptchaTimeout);
        }

        solve(captcha, waitOptions);
    }

    /**
     * Sends captcha to `/in.php` and waits for it's result.
     * This helper can be used instead of manual using of `send` and `getResult` functions.
     *
     * @param captcha
     * @param waitOptions
     * @throws Exception
     */
    public void solve(Captcha captcha, Map<String, Integer> waitOptions) throws Exception {
        captcha.setId(send(captcha));

        if (!lastCaptchaHasCallback) {
            waitForResult(captcha, waitOptions);
        }
    }

    /**
     * This helper waits for captcha result, and when result is ready, returns it
     *
     * @param captcha
     * @param waitOptions
     * @throws Exception
     */
    public void waitForResult(Captcha captcha, Map<String, Integer> waitOptions) throws Exception {
        long startedAt = (long)(System.currentTimeMillis() / 1000);

        int timeout = waitOptions.getOrDefault("timeout", this.defaultTimeout);
        int pollingInterval = waitOptions.getOrDefault("pollingInterval", this.pollingInterval);

        while (true) {
            long now = (long)(System.currentTimeMillis() / 1000);

            if (now - startedAt < timeout) {
                Thread.sleep(pollingInterval * 1000);
            } else {
                break;
            }

            try {
                String result = getResult(captcha.getId());
                if (result != null) {
                    captcha.setCode(result);
                    return;
                }
            } catch (NetworkException e) {
                // ignore network errors
            }
        }

        throw new TimeoutException("Timeout " + timeout + " seconds reached");
    }

    /**
     * Sends captcha to '/in.php', and returns its `id`
     *
     * @param captcha
     * @return
     * @throws Exception
     */
    public String send(Captcha captcha) throws Exception {
        Map<String, String> params = captcha.getParams();
        Map<String, File> files = captcha.getFiles();

        sendAttachDefaultParams(params);

        validateFiles(files);

        String response = apiClient.in(params, files);

        return handleResponse(response);
/*
        if (!response.startsWith("OK|")) {
            throw new ApiException("Cannot recognise api response (" + response + ")");
        }

        return response.substring(3);*/
    }

    String handleResponse(String response) {
        if (response.startsWith("OK|")) {
            return response.substring(3);
        } else {
            //{"status":1,"request":"77225795845"}
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.getString("request");
            /*if(response.contains("\"request\":"))
            return response["request"];*/
        }
    }

    /**
     * Returns result of captcha if it was solved or `null`, if result is not ready
     *
     * @param id
     * @return
     * @throws Exception
     */
    public String getResult(String id) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("action", "get");
        params.put("id", id);
        params.put("json", "1");

        String response = res(params);

        if (response.equals("CAPCHA_NOT_READY")) {
            return null;
        }

        return handleResponse(response);
    }

    /**
     * Gets account's balance
     *
     * @return
     * @throws Exception
     */
    public double balance() throws Exception {
        String response = res("getbalance");
        return Double.parseDouble(response);
    }

    /**
     * Reports if captcha was solved correctly (sends `reportbad` or `reportgood` to `/res.php`)
     *
     * @param id
     * @param correct
     * @throws Exception
     */
    public void report(String id, boolean correct) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);

        if (correct) {
            params.put("action", "reportgood");
        } else {
            params.put("action", "reportbad");
        }

        res(params);
    }

    /**
     * Makes request to `/res.php`
     *
     * @param action
     * @return
     * @throws Exception
     */
    private String res(String action) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("action", action);
        return res(params);
    }

    /**
     * Makes request to `/res.php`
     *
     * @param params
     * @return
     * @throws Exception
     */
    private String res(Map<String, String> params) throws Exception {
        params.put("key", apiKey);
        return apiClient.res(params);
    }

    /**
     * Attaches default parameters to request
     *
     * @param params
     */
    private void sendAttachDefaultParams(Map<String, String> params) {

        if (!params.containsKey("json")) {
            params.put("json", "1");
        }

        params.put("key", apiKey);

        if (callback != null) {
            if (!params.containsKey("pingback")) {
                params.put("pingback", callback);
            } else if (params.get("pingback").length() == 0) {
                params.remove("pingback");
            }
        }

        lastCaptchaHasCallback = params.containsKey("pingback");

        if (softId != 0 && !params.containsKey("soft_id")) {
            params.put("soft_id", String.valueOf(softId));
        }
    }

    /**
     * Validates if files parameters are correct
     *
     * @param files
     * @throws ValidationException
     */
    private void validateFiles(Map<String, File> files) throws ValidationException {
        for (Map.Entry<String, File> entry : files.entrySet()) {
            File file = entry.getValue();

            if (!file.exists()) {
                throw new ValidationException("File not found: " + file.getAbsolutePath());
            }

            if (!file.isFile()) {
                throw new ValidationException("Resource is not a file: " + file.getAbsolutePath());
            }
        }
    }

}
