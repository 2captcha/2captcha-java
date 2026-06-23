package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.AlibabaCaptcha;

public class AlibabaCaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        AlibabaCaptcha captcha = new AlibabaCaptcha();
        captcha.setSceneId("login");
        captcha.setPrefix("https://img.alicdn.com/tfs/...");
        captcha.setPageUrl("https://example.com/page-with-alibaba");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
