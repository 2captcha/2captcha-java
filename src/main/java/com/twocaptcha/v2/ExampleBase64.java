package com.twocaptcha.v2;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ExampleBase64 {

    private String key;

    public ExampleBase64(String key) {
        this.key = key;
    }

    private void resolve() throws IOException {
        ApiClient apiClient = new ApiClient(this.key);

        byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/rotate.jpg"));
        String base64EncodedImage = Base64.getEncoder().encodeToString(bytes);

        JSONObject innerJsonObject = new JSONObject()
                .put("type", "RotateTask")
                .put("body", base64EncodedImage)
                .put("comment", "position the image properly")
                .put("angle", 60);

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

    public static void main(String[] args) throws IOException {
        ExampleBase64 example = new ExampleBase64(args[0]);
        example.resolve();
    }

}
