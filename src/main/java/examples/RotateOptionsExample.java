package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Rotate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RotateOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);
        
        List<File> images = new ArrayList<>();
        images.add(new File("src/main/resources/rotate.jpg"));
        images.add(new File("src/main/resources/rotate_2.jpg"));
        images.add(new File("src/main/resources/rotate_3.jpg"));

        Rotate captcha = new Rotate();
        captcha.setFiles(images);
        captcha.setAngle(40);
        captcha.setLang("en");
        captcha.setHintImg(new File("src/main/resources/rotate_hint.jpg"));
        captcha.setHintText("Put the images in the correct way up");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
