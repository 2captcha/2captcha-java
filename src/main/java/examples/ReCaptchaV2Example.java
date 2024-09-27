package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.ReCaptcha;

public class ReCaptchaV2Example {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey("6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
        captcha.setUrl("https://mysite.com/page/with/recaptcha");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
