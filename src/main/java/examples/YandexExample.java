package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Yandex;

public class YandexExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        Yandex captcha = new Yandex();
        captcha.setSiteKey("Y5Lh0tiycconMJGsFd3EbbuNKSp1yaZESUOIHfeV");
        captcha.setUrl("https://rutube.ru");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
