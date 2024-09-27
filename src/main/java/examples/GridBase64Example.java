package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Grid;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class GridBase64Example {

    public static void main(String[] args) throws Exception {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/grid.jpg"));
        String base64EncodedImage = Base64.getEncoder().encodeToString(bytes);

        Grid captcha = new Grid();
        captcha.setBase64(base64EncodedImage);

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
