package examples;

import java.io.File;
import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Coordinates;

public class CoordinatesOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);
        
        Coordinates captcha = new Coordinates();
        captcha.setFile("src/main/resources/grid_2.jpg");
        captcha.setLang("en");
        captcha.setHintImg(new File("src/main/resources/grid_hint.jpg"));
        captcha.setHintText("Select all images with an Orange");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
