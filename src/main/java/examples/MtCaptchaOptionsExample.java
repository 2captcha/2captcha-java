package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.MtCaptcha;

public class MtCaptchaOptionsExample {
    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);

        MtCaptcha mtCaptcha = new MtCaptcha();
        mtCaptcha.setSiteKey("MTPublic-KzqLY1cKH");
        mtCaptcha.setPageUrl("https://2captcha.com/demo/mtcaptcha");
        mtCaptcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(mtCaptcha);
            System.out.println("Captcha solved: " + mtCaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
