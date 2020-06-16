package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.KeyCaptcha;

public class KeyCaptchaOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        KeyCaptcha captcha = new KeyCaptcha();
        captcha.setUserId(10);
        captcha.setSessionId("493e52c37c10c2bcdf4a00cbc9ccd1e8");
        captcha.setWebServerSign("9006dc725760858e4c0715b835472f22");
        captcha.setWebServerSign2("2ca3abe86d90c6142d5571db98af6714");
        captcha.setUrl("https://www.keycaptcha.ru/demo-magnetic/");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
