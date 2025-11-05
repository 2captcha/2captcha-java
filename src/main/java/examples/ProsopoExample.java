package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Prosopo;

public class ProsopoExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Prosopo captcha = new Prosopo();
        captcha.setSiteKey("5EZVvsHMrKCFKp5NYNoTyDjTjetoVo1Z4UNNbTwJf1GfN6Xm");
        captcha.setUrl("https://www.twickets.live/");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
