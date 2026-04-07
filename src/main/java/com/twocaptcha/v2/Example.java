package com.twocaptcha.v2;

import org.json.JSONObject;

public class Example {

    String key;

    public Example(String key) {
        this.key = key;
    }

    void resolve(){
        //        solver.setDefaultTimeout(120);
        //        solver.setRecaptchaTimeout(600);
        //        solver.setPollingInterval(10);
        ApiClient apiClient = new ApiClient(this.key);
        //apiClient.defaultTimeout = 333;
        //apiClient.pollingInterval = 22;
        JSONObject innerJsonObject = new JSONObject()
                .put("type", "TextCaptchaTask")
                .put("comment", "If tomorrow is Saturday, what day is today?");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientKey", this.key);
        jsonObject.put("languagePool", "ru");
        jsonObject.put("task", innerJsonObject);

        try {
            JSONObject resultJsonObject = apiClient.solve(jsonObject);
            System.out.println("Captcha solved: " + resultJsonObject.toString());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Example example = new Example(args[0]);
        example.resolve();
    }

}
