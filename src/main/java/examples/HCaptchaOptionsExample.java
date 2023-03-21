package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.HCaptcha;

public class HCaptchaOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);
        
        HCaptcha captcha = new HCaptcha();
        captcha.setSiteKey("10000000-ffff-ffff-ffff-000000000001");
        captcha.setUrl("https://www.site.com/page/");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
