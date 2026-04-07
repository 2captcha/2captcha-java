package com.twocaptcha.v2;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    String apiKey;
    private Long id;
    int timeout = 120;
    int pollingInterval = 10;
    HttpClient httpClient = HttpClient.newHttpClient();
    String createTaskUri = "https://api.2captcha.com/createTask";
    String getTaskResultUri = "https://api.2captcha.com/getTaskResult";

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject solve(JSONObject jsonObject) throws Exception {
        this.id = createTask(jsonObject);
        return getTaskResult(this.id);
    }

    private HttpRequest request (JSONObject jsonObject, String uri){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
                .build();
        return request;
    }

    private Long createTask(JSONObject jsonObject) throws IOException, InterruptedException {

        HttpRequest request = request(jsonObject, createTaskUri);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        JSONObject responseJsonObject = new JSONObject(response.body());
        return responseJsonObject.getLong("taskId");
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

                JSONObject jsonObjectResponse = new JSONObject(response.body());
                /*
                Body: {"errorId":12,"errorCode":"ERROR_CAPTCHA_UNSOLVABLE","errorDescription":"Workers could not solve the Captcha"}
                 */
                String status = jsonObjectResponse.getString("status");
                if(status.equals("ready")) {
                    return jsonObjectResponse;
                }

            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }

        throw new TimeoutException("Timeout " + this.timeout + " seconds reached");
    }
}