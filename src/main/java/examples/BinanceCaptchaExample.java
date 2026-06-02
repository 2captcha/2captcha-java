package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.BinanceCaptcha;
import com.twocaptcha.captcha.Yandex;

public class BinanceCaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        BinanceCaptcha captcha = new BinanceCaptcha();
        captcha.setSiteKey("login");
        captcha.setPageUrl("https://example.com/page-with-binance");
        captcha.setValidateId("cb0bfef...e54ecd57b");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
