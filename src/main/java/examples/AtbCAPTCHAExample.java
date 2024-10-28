package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.AtbCAPTCHA;

public class AtbCAPTCHAExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        AtbCAPTCHA captcha = new AtbCAPTCHA();
        captcha.setAppId("af23e041b22d000a11e22a230fa8991c");
        captcha.setPageUrl("https://www.playzone.vip/");
        captcha.setApiServer("https://cap.aisecurius.com");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
