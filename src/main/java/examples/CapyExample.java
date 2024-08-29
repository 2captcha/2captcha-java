package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Capy;

public class CapyExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Capy captcha = new Capy();
        captcha.setSiteKey("PUZZLE_Abc1dEFghIJKLM2no34P56q7rStu8v");
        captcha.setUrl("https://www.mysite.com/captcha/");
        captcha.setApiServer("https://jp.api.capy.me/");


        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
