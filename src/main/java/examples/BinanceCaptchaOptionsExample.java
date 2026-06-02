package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.BinanceCaptcha;
import com.twocaptcha.captcha.Yandex;

public class BinanceCaptchaOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);

        BinanceCaptcha captcha = new BinanceCaptcha();
        captcha.setSiteKey("login");
        captcha.setPageUrl("https://example.com/page-with-binance");
        captcha.setValidateId("cb0bfef...e54ecd57b");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
