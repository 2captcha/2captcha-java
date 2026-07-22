package com.twocaptcha.generic;

import org.json.JSONObject;

public class Example {

    private String key;
    ApiClient apiClient = null;

    public Example(String key) {
        this.key = key;
        apiClient = new ApiClient(this.key);
    }

    private void resolve(){
        JSONObject innerJsonObject = new JSONObject()
                .put("type", "TextCaptchaTask")
                .put("comment", "If tomorrow is Saturday, what day is today?");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientKey", this.key);
        jsonObject.put("languagePool", "en");
        jsonObject.put("task", innerJsonObject);

        try {
            JSONObject resultJsonObject = apiClient.solve(jsonObject);
            System.out.println("Result: " + resultJsonObject.toString());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private void getBalance(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientKey", this.key);
        try {
            JSONObject resultJsonObject = apiClient.getBalance(jsonObject);
            System.out.println("Result: " + resultJsonObject.toString());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private void reportCorrect(){
        if(apiClient.taskId < 0) return;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientKey", this.key);
        jsonObject.put("taskId", apiClient.taskId);
        try {
            JSONObject resultJsonObject = apiClient.reportCorrect(jsonObject);
            System.out.println("Result: " + resultJsonObject.toString());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private void reportIncorrect(){
        if(apiClient.taskId < 0) return;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientKey", this.key);
        jsonObject.put("taskId", apiClient.taskId);
        try {
            JSONObject resultJsonObject = apiClient.reportIncorrect(jsonObject);
            System.out.println("Result: " + resultJsonObject.toString());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Provide api key as first parameter");
            return;
        }

        Example example = new Example(args[0]);
        example.resolve();
        example.getBalance();
        example.reportCorrect();
        example.reportIncorrect();
    }

}
