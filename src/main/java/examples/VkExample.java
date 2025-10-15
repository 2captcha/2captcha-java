package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Canvas;
import com.twocaptcha.captcha.Rotate;
import com.twocaptcha.captcha.VkCaptcha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class VkExample {

    private void imageBased(String apiKey) throws IOException {
        TwoCaptcha solver = new TwoCaptcha(apiKey);
        solver.setExtendedResponse(1);

        byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/vk.jpg"));
        String base64EncodedImage = Base64.getEncoder().encodeToString(bytes);


        VkCaptcha captcha = new VkCaptcha("vkimage");
        captcha.setImageBase64(base64EncodedImage);
        captcha.setSteps("[5,12,22,24,21,23,10,7,2,8,19,18,8,24,21,22,11,14,16,5,18,20,4,21,12,6,0,0,11,12,8,20,19,3,14,8,9,13,16,24,18,3,2,23,8,12,6,1,11,0,20,15,19,22,17,24,8,0,12,5,19,14,11,6,7,14,23,24,23,20,4,20,6,12,4,17,4,18,6,20,17,5,23,7,10,2,8,9,5,4,17,24,11,14,4,10,12,22,21,2]");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private void tokenBased(String apiKey) throws IOException {
        TwoCaptcha solver = new TwoCaptcha(apiKey);
        VkCaptcha captcha = new VkCaptcha("vkcaptcha");
        captcha.setRedirectUri("https://id.vk.com/not_robot_captcha?domain=vk.com&session_token=eyJ....HGsc5B4LyvjA&variant=popup&blank=1");
        captcha.setuserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
        captcha.setProxy("http", "1.2.3.4");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        VkExample vkExample = new VkExample();
        vkExample.imageBased(args[0]);
        //vkExample.tokenBased(args[0]);
    }

}
