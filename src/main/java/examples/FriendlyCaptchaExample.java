package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.FriendlyCaptcha;

public class FriendlyCaptchaExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("4c16347a073355ab15325ba67caaca03");

        FriendlyCaptcha friendlyCaptcha = new FriendlyCaptcha();
        friendlyCaptcha.setSiteKey("FCMST5VUMCBOCGQ9");
        friendlyCaptcha.setPageUrl("https://geizhals.de/455973138?fsean=5901747021356");
        //friendlyCaptcha.setResponseTypeString();

        try {
            solver.solve(friendlyCaptcha);
            System.out.println("Captcha solved: " + friendlyCaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
