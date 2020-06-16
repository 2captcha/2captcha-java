package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Text;

public class TextOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        Text captcha = new Text();
        captcha.setText("If tomorrow is Saturday, what day is today?");
        captcha.setLang("en");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
