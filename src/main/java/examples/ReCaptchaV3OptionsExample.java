package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.ReCaptcha;

public class ReCaptchaV3OptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey("6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
        captcha.setUrl("https://mysite.com/page/with/recaptcha");
        captcha.setVersion("v3");
        captcha.setAction("verify");
        captcha.setScore(0.3);
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
