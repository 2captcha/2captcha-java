package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Rotate;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class RotateOptionsExample {

    public static void main(String[] args) throws Exception {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);
        
        byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/rotate.jpg"));        
        String base64EncodedImage = Base64.getEncoder().encodeToString(bytes);


        Rotate captcha = new Rotate();
        captcha.setBase64(base64EncodedImage);
        captcha.setAngle(40);
        captcha.setLang("en");
        captcha.setHintImg(new File("src/main/resources/rotate_2.jpg"));
        captcha.setHintText("Put the images in the correct way up");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
