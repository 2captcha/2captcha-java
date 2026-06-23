package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Basilisk;

public class BasiliskExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Basilisk captcha = new Basilisk();
        captcha.setSiteKey("b7890h...19fb2600897");
        captcha.setUrl("https://example.com/page-with-basilisk");
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
