package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Hunt;

public class HuntExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Hunt captcha = new Hunt();
        captcha.setPageUrl("https://example.com/page-with-hunt");
        captcha.setApiGetLib("https://example.com/api.js");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
