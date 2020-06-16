package examples;

import com.twocaptcha.TwoCaptcha;
import java.io.File;
import com.twocaptcha.captcha.Normal;

public class NormalOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        Normal captcha = new Normal();
        captcha.setFile("src/main/resources/normal_2.jpg");
        captcha.setNumeric(4);
        captcha.setMinLen(4);
        captcha.setMaxLen(20);
        captcha.setPhrase(true);
        captcha.setCaseSensitive(true);
        captcha.setCalc(false);
        captcha.setLang("en");
        captcha.setHintImg(new File("src/main/resources/normal_hint.jpg"));
        captcha.setHintText("Type red symbols only");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
