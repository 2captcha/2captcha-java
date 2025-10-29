package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Captcha;
import com.twocaptcha.constants.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class VkNewExample {

    String key;
    Map<String, String> params;
    Map<String, File> files;

    String method = "vkimage";
    String body = "";
    String steps = "[5,12,22,24,21,23,10,7,2,8,19,18,8,24,21,22,11,14,16,5,18,20,4,21,12,6,0,0,11,12,8,20,19,3,14,8,9,13,16,24,18,3,2,23,8,12,6,1,11,0,20,15,19,22,17,24,8,0,12,5,19,14,11,6,7,14,23,24,23,20,4,20,6,12,4,17,4,18,6,20,17,5,23,7,10,2,8,9,5,4,17,24,11,14,4,10,12,22,21,2]";

    public VkNewExample(String key) {
        this.key = key;
        params = new HashMap<>();
        files = new HashMap<>();
    }

    void resolve() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/vk.jpg"));
        body = Base64.getEncoder().encodeToString(bytes);

        TwoCaptcha solver = new TwoCaptcha(this.key);
        Captcha сaptcha = new Captcha();

        params.put(Constants.METHOD, method);
        params.put(Constants.BODY, body);
        params.put(Constants.STEPS, steps);

        сaptcha.params = params;
        try {
            solver.solve(сaptcha);
            System.out.println("Captcha solved: " + сaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        VkNewExample textExample = new VkNewExample(args[0]);
        textExample.resolve();
    }

}
