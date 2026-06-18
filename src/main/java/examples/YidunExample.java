package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Yidun;

public class YidunExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Yidun captcha = new Yidun();
        captcha.setSiteKey("0f743r3g1...8rz3grz0ym5");
        captcha.setPageUrl("https://example.com/page-with-yidun");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
