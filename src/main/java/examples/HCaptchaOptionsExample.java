package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.HCaptcha;

public class HCaptchaOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);
        solver.setExtendedResponse(1);
        
        HCaptcha captcha = new HCaptcha();
        captcha.setSiteKey("c0421d06-b92e-47fc-ab9a-5caa43c04538");
        captcha.setUrl("https://2captcha.com/demo/hcaptcha");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
