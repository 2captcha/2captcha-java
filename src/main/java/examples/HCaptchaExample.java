package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.HCaptcha;

public class HCaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        HCaptcha captcha = new HCaptcha();
        captcha.setSiteKey("c0421d06-b92e-47fc-ab9a-5caa43c04538");
        captcha.setUrl("https://2captcha.com/demo/hcaptcha");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
