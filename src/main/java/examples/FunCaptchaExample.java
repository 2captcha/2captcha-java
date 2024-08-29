package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.FunCaptcha;

public class FunCaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        FunCaptcha captcha = new FunCaptcha();
        captcha.setSiteKey("69A21A01-CC7B-B9C6-0F9A-E7FA06677FFC");
        captcha.setUrl("https://mysite.com/page/with/funcaptcha");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
