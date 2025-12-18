package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.Temu;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class TemuExample {

    public static void main(String[] args) throws Exception {
        TwoCaptcha solver = new TwoCaptcha(args[0]);

        byte[] bodyBytes = Files.readAllBytes(Paths.get("src/main/resources/temu/body.png"));
        String body = Base64.getEncoder().encodeToString(bodyBytes);
        byte[] part1Bytes = Files.readAllBytes(Paths.get("src/main/resources/temu/part1.png"));
        String part1 = Base64.getEncoder().encodeToString(part1Bytes);
        byte[] part2Bytes = Files.readAllBytes(Paths.get("src/main/resources/temu/part2.png"));
        String part2 = Base64.getEncoder().encodeToString(part2Bytes);
        byte[] part3Bytes = Files.readAllBytes(Paths.get("src/main/resources/temu/part3.png"));
        String part3 = Base64.getEncoder().encodeToString(part3Bytes);

        Temu captcha = new Temu();
        captcha.setBody(body);
        captcha.setPart1(part1);
        captcha.setPart2(part2);
        captcha.setPart3(part3);

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
