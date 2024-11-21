package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Lemin;

public class LeminExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Lemin captcha = new Lemin();      
        captcha.setСaptchaId("CROPPED_d3d4d56_73ca4008925b4f83a8bed59c2dd0df6d");
        captcha.setUrl("https://mysite.com/page/with/FriendlyCaptcha");
        captcha.setApiServer("api.leminnow.com");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
