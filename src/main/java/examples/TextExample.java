package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Text;

public class TextExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        Text captcha = new Text("If tomorrow is Saturday, what day is today?");
        captcha.setLang("en");
        Text captcha1 = new Text("If tomorrow is Monday, what day is today?");
        captcha.setLang("en");
        Text captcha2 = new Text("If tomorrow is Thursday, what day is today?");
        captcha.setLang("en");

        try {
            new Thread(() -> {
                System.out.println("Start Captcha solving...");
                try {
                    solver.solve(captcha);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Captcha solved: " + captcha.getCode());
            }).start();

            new Thread(() -> {
                System.out.println("Start Captcha 1 solving...");
                try {
                    solver.solve(captcha1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Captcha 1 solved: " + captcha1.getCode());
            }).start();

            new Thread(() -> {
                System.out.println("Start Captcha 2 solving...");
                try {
                    solver.solve(captcha2);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Captcha 2 solved: " + captcha2.getCode());
            }).start();


        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
