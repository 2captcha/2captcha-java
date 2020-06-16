package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Rotate;

public class RotateExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        Rotate captcha = new Rotate("src/main/resources/rotate.jpg");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
