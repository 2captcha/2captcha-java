package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.GeeTestV4;

public class GeeTestV4OptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);
        
        GeeTestV4 captcha = new GeeTestV4();
        captcha.setCaptchaId("72bf15796d0b69c43867452fea615052");
        captcha.setApiServer("api-na.geetest.com");
        captcha.setChallenge("12345678abc90123d45678ef90123a456b");
        captcha.setUrl("https://mysite.com/captcha.html");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");


        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
