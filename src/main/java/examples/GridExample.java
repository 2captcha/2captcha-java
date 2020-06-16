package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Grid;

public class GridExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        Grid captcha = new Grid("src/main/resources/grid.jpg");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
