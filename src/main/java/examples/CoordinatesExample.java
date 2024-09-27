package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Coordinates;

public class CoordinatesExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Coordinates captcha = new Coordinates("src/main/resources/grid.jpg");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
