package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Text;

public class TextExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Text captcha = new Text("If tomorrow is Saturday, what day is today?");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
