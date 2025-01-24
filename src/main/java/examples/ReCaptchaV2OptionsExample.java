package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.ReCaptcha;

public class ReCaptchaV2OptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);
        
        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey("6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
        captcha.setUrl("https://mysite.com/page/with/recaptcha");
        captcha.setInvisible(true);
        captcha.setEnterprise(true);
        captcha.setData("foo");
        captcha.setAction("verify");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36");
        captcha.setCookies("KEY1:Value1;KEY2:Value2;");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
