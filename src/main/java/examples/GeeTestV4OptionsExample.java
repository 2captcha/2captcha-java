package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.GeeTestV4;

public class GeeTestV4OptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
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
        captcha.setRiskType("slide|1779887038.402245|6563f67750ef47d9b1302ef524gf719f|04fe1ca6a68510c08f6f9aacfe4ce284a9e672d9ecb4212e6cd593ad583ef054");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");


        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
