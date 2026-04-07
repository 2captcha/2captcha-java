package com.twocaptcha.v2;

import com.twocaptcha.exceptions.TimeoutException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiClient {
    private String apiKey;
    private Long id;
    private int defaultTimeout = 120;
    private int pollingInterval = 10;

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject solve(JSONObject jsonObject, Map<String, Integer> waitOptions) throws Exception {
        this.id = send(jsonObject);
        return waitForResult(this.id, waitOptions);
    }

    private Long send(JSONObject jsonObject) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.2captcha.com/createTask"))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        JSONObject responseJsonObject = new JSONObject(response.body());
        return responseJsonObject.getLong("taskId");
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
                //json.put("clientKey", this.key);
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
}