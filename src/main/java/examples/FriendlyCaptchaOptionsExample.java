package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.FriendlyCaptcha;

public class FriendlyCaptchaOptionsExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);

        FriendlyCaptcha friendlyCaptcha = new FriendlyCaptcha();
        friendlyCaptcha.setSiteKey("FCMST5VUMCBOCGQ9");
        friendlyCaptcha.setPageUrl("https://mysite.com/page/with/FriendlyCaptcha");
        friendlyCaptcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        try {
            solver.solve(friendlyCaptcha);
            System.out.println("Captcha solved: " + friendlyCaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
