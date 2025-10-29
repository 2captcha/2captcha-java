package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Captcha;
import com.twocaptcha.captcha.GenericCaptcha;
import com.twocaptcha.captcha.Text;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TextExample {

    String key;
    Map<String, String> params;
    Map<String, File> files;

    String text = "If tomorrow is Saturday, what day is today?";

    public TextExample(String key) {
        this.key = key;
        params = new HashMap<>();
        files = new HashMap<>();
    }

    void resolve(){
        TwoCaptcha solver = new TwoCaptcha(this.key);
        Captcha сaptcha = new Captcha();

        params.put("method", "post");
        params.put("textcaptcha", text);

        сaptcha.params = params;
        try {
            solver.solve(сaptcha);
            System.out.println("Captcha solved: " + сaptcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        TextExample textExample = new TextExample(args[0]);
        textExample.resolve();
    }

}
