package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Prosopo;

public class ProsopoExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Prosopo captcha = new Prosopo();
        captcha.setSiteKey("5EPQoMZEDc5LpN7gtxMMzYPTzA6UeWqL2stk1rso9gy4Ahqt");
        captcha.setUrl("https://www.example.com/");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
