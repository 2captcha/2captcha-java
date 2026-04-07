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
    String apiKey;
    private Long id;
    int timeout = 120;
    int pollingInterval = 10;

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject solve(JSONObject jsonObject) throws Exception {
        this.id = send(jsonObject);
        return waitForResult(this.id);
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

    public JSONObject waitForResult(Long taskId) throws Exception {
        long startedAt = (long) (System.currentTimeMillis() / 1000);

        while (true) {
            long now = (long) (System.currentTimeMillis() / 1000);

            if (now - startedAt < this.timeout) {
                Thread.sleep(this.pollingInterval * 1000);
            } else {
                break;
            }

            try {
                JSONObject json = new JSONObject();
                json.put("clientKey", this.apiKey);
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

        throw new TimeoutException("Timeout " + this.timeout + " seconds reached");
    }
}