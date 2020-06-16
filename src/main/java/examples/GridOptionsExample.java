package examples;

import com.twocaptcha.TwoCaptcha;
import java.io.File;
import com.twocaptcha.captcha.Grid;

public class GridOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        Grid captcha = new Grid();
        captcha.setFile("src/main/resources/grid_2.jpg");
        captcha.setRows(3);
        captcha.setCols(3);
        captcha.setPreviousId(0);
        captcha.setCanSkip(false);
        captcha.setLang("en");
        captcha.setHintImg(new File("src/main/resources/grid_hint.jpg"));
        captcha.setHintText("Select all images with an Orange");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
