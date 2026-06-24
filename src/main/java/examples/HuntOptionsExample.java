package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Hunt;

public class HuntOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);

        Hunt captcha = new Hunt();
        captcha.setPageUrl("https://example.com/page-with-hunt");
        captcha.setApiGetLib("https://example.com/api.js");
        captcha.setData("meta.token.value");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
