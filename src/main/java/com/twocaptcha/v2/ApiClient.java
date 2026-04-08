package com.twocaptcha.v2;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private int softId = 4581;
    String apiKey;
    private Long id;
    int timeout = 160;
    int pollingInterval = 10;
    HttpClient httpClient = HttpClient.newHttpClient();
    String createTaskUri = "https://api.2captcha.com/createTask";
    String getTaskResultUri = "https://api.2captcha.com/getTaskResult";

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject solve(JSONObject jsonObject) throws Exception {
        jsonObject.put("softId", softId);
        JSONObject responseJsonObject = createTask(jsonObject);
        this.id = responseJsonObject.getLong("taskId");

        if (jsonObject.getJSONObject("task").has("callbackUrl")
                && !jsonObject.getJSONObject("task").getString("callbackUrl").isEmpty())
            return responseJsonObject;
        return getTaskResult(this.id);
    }

    private HttpRequest request(JSONObject jsonObject, String uri) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
                .build();
        return request;
    }

    private JSONObject createTask(JSONObject jsonObject) throws IOException, InterruptedException {

        HttpRequest request = request(jsonObject, createTaskUri);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        JSONObject responseJsonObject = new JSONObject(response.body());
        return responseJsonObject;
    }

    public JSONObject getTaskResult(Long taskId) throws Exception {
        long startedAt = (long) (System.currentTimeMillis() / 1000);

        while (true) {
            long now = (long) (System.currentTimeMillis() / 1000);

            if (now - startedAt < this.timeout) {
                Thread.sleep(this.pollingInterval * 1000);
            } else {
                break;
            }

            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("clientKey", this.apiKey);
                jsonObject.put("taskId", taskId);

                HttpRequest request = request(jsonObject, getTaskResultUri);
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println("Status: " + response.statusCode());
                System.out.println("Body: " + response.body());

                //temp JSONObject jsonObjectResponse = new JSONObject(response.body());
//test
                String jsonStr = "{\"errorId\":12,\"errorCode\":\"ERROR_CAPTCHA_UNSOLVABLE\",\"errorDescription\":\"Workers could not solve the Captcha\"}";
                JSONObject jsonObjectResponse = new JSONObject(jsonStr);
                /*
                Body: {"errorId":12,"errorCode":"ERROR_CAPTCHA_UNSOLVABLE","errorDescription":"Workers could not solve the Captcha"}
                 */

                if(jsonObjectResponse.has("errorId")
                        && !jsonObjectResponse.getString("errorId").isEmpty())
                    return jsonObjectResponse;

                String status = jsonObjectResponse.getString("status");
                if (status.equals("ready")) {
                    return jsonObjectResponse;
                }

            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }

        throw new TimeoutException("Timeout " + this.timeout + " seconds reached");
    }
}