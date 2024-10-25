package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Cutcaptcha;

public class CutcaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Cutcaptcha cutcaptcha = new Cutcaptcha();
        cutcaptcha.setMiseryKey("a1488b66da00bf332a1488993a5443c79047e752");
        cutcaptcha.setUrl("https://filecrypt.co/Container/237D4D0995.html");
        cutcaptcha.setDataApiKey("SAb83IIB");

        try {
            solver.solve(cutcaptcha);
            System.out.println("Captcha solved: " + cutcaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
