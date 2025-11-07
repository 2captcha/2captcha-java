package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.VkCaptcha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class VkCaptchaExample {

    private void imageBased(String apiKey) throws IOException {
        TwoCaptcha solver = new TwoCaptcha(apiKey);
        solver.setExtendedResponse(1);

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
        VkCaptchaExample vkExample = new VkCaptchaExample();
        vkExample.imageBased(args[0]);
        //vkExample.tokenBased(args[0]);
    }

}
