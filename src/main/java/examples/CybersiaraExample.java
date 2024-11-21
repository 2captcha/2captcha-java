package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Cybersiara;

public class CybersiaraExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Cybersiara captcha = new Cybersiara();
        captcha.setMasterUrlId("tpjOCKjjpdzv3d8Ub2E9COEWKt1vl1Mv");
        captcha.setUrl("https://demo.mycybersiara.com/");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
