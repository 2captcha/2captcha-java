package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.TwoCaptchaV2;
import com.twocaptcha.captcha.Captcha;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TextExampleV2 {

    String key;
    Map<String, String> params;
    Map<String, File> files;

    String text = "If tomorrow is Saturday, what day is today?";

    public TextExampleV2(String key) {
        this.key = key;
        params = new HashMap<>();
        files = new HashMap<>();
    }

    void resolve(){
        TwoCaptchaV2 solver = new TwoCaptchaV2(this.key);
        Captcha сaptcha = new Captcha();

        params.put("type", "AltchaTaskProxyless");
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
        TextExampleV2 textExampleV2 = new TextExampleV2(args[0]);
        textExampleV2.resolve();
    }

}
