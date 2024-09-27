package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.FriendlyCaptcha;

public class FriendlyCaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        FriendlyCaptcha friendlyCaptcha = new FriendlyCaptcha();
        friendlyCaptcha.setSiteKey("FCMST5VUMCBOCGQ9");
        friendlyCaptcha.setPageUrl("https://mysite.com/page/with/FriendlyCaptcha");

        try {
            solver.solve(friendlyCaptcha);
            System.out.println("Captcha solved: " + friendlyCaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
