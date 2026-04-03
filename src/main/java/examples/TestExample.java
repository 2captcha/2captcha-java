package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Captcha;
import com.twocaptcha.exceptions.NetworkException;
import com.twocaptcha.exceptions.TimeoutException;
import org.json.JSONObject;

import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class TestExample {

    String key;
    private int defaultTimeout = 120;
    private int pollingInterval = 10;
    String text = "If tomorrow is Saturday, what day is today?";

    public TestExample(String key) {
        this.key = key;

    }

    /*
    Body: {"errorId":12,"errorCode":"ERROR_CAPTCHA_UNSOLVABLE","errorDescription":"Workers could not solve the Captcha"}
Error occurred: JSONObject["status"] not found.
    ----------------------------------
    {
  "errorDescription" : "Sandbox is full",
  "errorCode" : "ERROR_NO_SLOT_AVAILABLE",
  "errorId" : 2
}
----------------------------

{"errorId":16,"errorCode":"ERROR_NO_SUCH_CAPCHA_ID","errorDescription":"You are trying to get the answer or complain a captcha that was submitted more than 15 minutes ago."}
     */
    void resolve() {
        Long taskId = -1L;
        try {
            JSONObject inner = new JSONObject()
                    .put("type", "TextCaptchaTask")
                    .put("comment", "If tomorrow is Saturday, what day is today?");

            JSONObject json = new JSONObject();
            json.put("clientKey", "06c869c488704f62826181f2562ac999");
            json.put("languagePool", "ru");
            json.put("task", inner);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.2captcha.com/createTask"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status: " + response.statusCode());
            System.out.println("Body: " + response.body());

            JSONObject jsonObject = new JSONObject(response.body());
            taskId = jsonObject.getLong("taskId");

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        try {
            Map<String, Integer> waitOptions = new HashMap<>();
            if (taskId != null)
                waitForResult(taskId, waitOptions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject waitForResult(Long taskId, Map<String, Integer> waitOptions) throws Exception {
        long startedAt = (long) (System.currentTimeMillis() / 1000);

        int timeout = waitOptions.getOrDefault("timeout", this.defaultTimeout);
        int pollingInterval = waitOptions.getOrDefault("pollingInterval", this.pollingInterval);

        while (true) {
            long now = (long) (System.currentTimeMillis() / 1000);

            if (now - startedAt < timeout) {
                Thread.sleep(pollingInterval * 1000);
            } else {
                break;
            }

            /*try {

                //Object result = getResult(captcha.getId());
                {
                    "clientKey": "YOUR_API_KEY",
                        "taskId": 74372499131
                }

                if (result != null) {
                    captcha.setCode(String.valueOf(result));
                    return;
                }
            } catch (NetworkException e) {
                // ignore network errors
            }*/
            try {
                JSONObject json = new JSONObject();
                json.put("clientKey", "06c869c488704f62826181f2562ac999");
                json.put("taskId", taskId);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://api.2captcha.com/getTaskResult"))
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println("Status: " + response.statusCode());
                System.out.println("Body: " + response.body());

                JSONObject jsonObject = new JSONObject(response.body());
                String status = jsonObject.getString("status");
                if(status.equals("ready")) {
                    return jsonObject;
                }

            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }

        throw new TimeoutException("Timeout " + timeout + " seconds reached");
    }

    public static void main(String[] args) {
        TestExample textExample = new TestExample(args[0]);
        textExample.resolve();
    }

}
