package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.MtCaptcha;

public class MtCaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        MtCaptcha mtCaptcha = new MtCaptcha();
        mtCaptcha.setSiteKey("MTPublic-KzqLY1cKH");
        mtCaptcha.setPageUrl("https://2captcha.com/demo/mtcaptcha");

        try {
            solver.solve(mtCaptcha);
            System.out.println("Captcha solved: " + mtCaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
