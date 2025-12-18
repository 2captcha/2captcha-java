package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Captchafox;
import com.twocaptcha.captcha.Turnstile;

public class CaptchafoxExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Captchafox captcha = new Captchafox();
        captcha.setSiteKey("sk_ILKWNruBBVKDOM7dZs59KHnDLEWiH");
        captcha.setUrl("https://mysite.com/page/with/captchafox");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
