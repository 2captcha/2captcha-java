package com.twocaptcha.generic;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private int softId = 4581;
    String apiKey;
    Long taskId = -1L;
    int timeout = 160;
    int pollingInterval = 10;
    HttpClient httpClient = HttpClient.newHttpClient();
    String createTaskUri = "https://api.rucaptcha.com/createTask";
    String getTaskResultUri = "https://api.rucaptcha.com/getTaskResult";
    String getBalanceUri = "https://api.rucaptcha.com/getBalance";
    String reportCorrectUri = "https://api.rucaptcha.com/reportCorrect";
    String reportIncorrectUri = "https://api.rucaptcha.com/reportIncorrect";

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject solve(JSONObject jsonObject) throws Exception {
        jsonObject.put("softId", softId);
        JSONObject responseJsonObject = createTask(jsonObject);
        this.taskId = responseJsonObject.getLong("taskId");

        if (jsonObject.getJSONObject("task").has("callbackUrl")
                && !jsonObject.getJSONObject("task").getString("callbackUrl").isEmpty())
            return responseJsonObject;
        return getTaskResult(this.taskId);
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

    private JSONObject createTask(JSONObject jsonObject) throws Exception {
        System.out.println("CreateTask Request");
        return doRequest(createTaskUri, jsonObject);
    }

    public JSONObject getTaskResult(Long taskId) throws Exception {
        long startedAt = (long) (System.currentTimeMillis() / 1000);

        int requestNum = 0;
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

                System.out.println("GetTaskResult Request N: " + ++requestNum);
                System.out.println("Status: " + response.statusCode());
                System.out.println("Body: " + response.body());

                JSONObject jsonObjectResponse = new JSONObject(response.body());

                if (jsonObjectResponse.has("errorId")
                        && jsonObjectResponse.getInt("errorId") > 0)
                    return jsonObjectResponse;

                String status = jsonObjectResponse.getString("status");
                if (status.equals("ready")) {
                    return jsonObjectResponse;
                }

            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }

        throw new Exception("Timeout " + this.timeout + " seconds reached");
    }

    public JSONObject getBalance(JSONObject jsonObject) throws Exception {
        System.out.println("Balance Request");
        return doRequest(getBalanceUri, jsonObject);
    }

    public JSONObject reportCorrect(JSONObject jsonObject) throws Exception {
        System.out.println("Report Correct Request");
        return doRequest(reportCorrectUri, jsonObject);
    }

    public JSONObject reportIncorrect(JSONObject jsonObject) throws Exception {
        System.out.println("Report Incorrect Request");
        return doRequest(reportIncorrectUri, jsonObject);
    }

    private JSONObject doRequest(String uri, JSONObject jsonObject) throws Exception {
        HttpRequest request = request(jsonObject, uri);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());

        JSONObject responseJsonObject = new JSONObject(response.body());
        return responseJsonObject;
    }
}