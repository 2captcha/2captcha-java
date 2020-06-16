package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Canvas;

public class CanvasExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        Canvas captcha = new Canvas();
        captcha.setFile("src/main/resources/canvas.jpg");
        captcha.setHintText("Draw around apple");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
