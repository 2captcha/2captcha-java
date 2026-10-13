package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Imperva;

public class ImpervaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Imperva captcha = new Imperva();
        captcha.setPageUrl("https://example.com/login");
        captcha.setIncapsulaScriptUrl("/_Incapsula_Resource?SWUDNSAI=31&xinfo=1");
        captcha.setIncapsulaCookies("visid_incap_123456=sample; incap_ses_123_123456=sample");
        captcha.setReese84UrlEndpoint("https://example.com/_Incapsula_Resource?reese84=1");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        captcha.setProxy("HTTP", "login:password@IP_address:PORT");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
