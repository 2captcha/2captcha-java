package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.HCaptcha;

public class HCaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        HCaptcha captcha = new HCaptcha();
        captcha.setSiteKey("10000000-ffff-ffff-ffff-000000000001");
        captcha.setUrl("https://www.site.com/page/");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
