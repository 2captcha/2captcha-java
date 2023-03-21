package examples;

import java.io.File;
import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Canvas;

public class CanvasOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);
        
        Canvas captcha = new Canvas();
        captcha.setFile("src/main/resources/canvas.jpg");
        captcha.setPreviousId(0);
        captcha.setCanSkip(false);
        captcha.setLang("en");
        captcha.setHintImg(new File("src/main/resources/canvas_hint.jpg"));
        captcha.setHintText("Draw around apple");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
