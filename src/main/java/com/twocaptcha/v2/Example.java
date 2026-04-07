package com.twocaptcha.v2;

import org.json.JSONObject;

public class Example {

    String key;

    public Example(String key) {
        this.key = key;
    }

    void resolve(){
        ApiClient apiClient = new ApiClient(this.key);
        JSONObject innerJsonObject = new JSONObject()
                .put("type", "TextCaptchaTask")
                .put("comment", "If tomorrow is Saturday, what day is today?");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientKey", this.key);
        jsonObject.put("languagePool", "ru");
        jsonObject.put("task", innerJsonObject);

        try {
            JSONObject resultJsonObject = apiClient.solve(jsonObject);
            //System.out.println("Captcha solved: " + сaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Example example = new Example(args[0]);
        example.resolve();
    }

}
