package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.AmazonWaf;

public class AmazonWafExample {

    public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");

        AmazonWaf captcha = new AmazonWaf();
        captcha.setSiteKey("AQIDAHjcYu/GjX+QlghicBgQ/7bFaQZ+m5FKCMDnO+vTbNg96AF5H1K/siwSLK7RfstKtN5bAAAAfjB8BgkqhkiG9w0BBwagbzBtAgEAMGgGCSqGSIb3DQEHATAeBglg");
        captcha.setUrl("https://non-existent-example.execute-api.us-east-1.amazonaws.com");
        captcha.setIV("test_iv");
        captcha.setContext("test_context");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
