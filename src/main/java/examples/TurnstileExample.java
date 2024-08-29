package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Turnstile;

public class TurnstileExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Turnstile captcha = new Turnstile();
        captcha.setSiteKey("0x4AAAAAAAChNiVJM_WtShFf");
        captcha.setUrl("https://ace.fusionist.io");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
