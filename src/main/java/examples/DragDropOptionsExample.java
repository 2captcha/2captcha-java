package examples;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.DragDrop;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

public class DragDropOptionsExample {

    public static void main(String[] args) throws Exception {
        TwoCaptcha solver = new TwoCaptcha(args[0]);
        solver.setHost("rucaptcha.com");
        solver.setSoftId(0);
        solver.setDefaultTimeout(120);
        solver.setRecaptchaTimeout(600);
        solver.setPollingInterval(10);

        byte[] backgroundBytes = Files.readAllBytes(Paths.get("src/main/resources/grid_2.jpg"));
        String background = Base64.getEncoder().encodeToString(backgroundBytes);

        byte[] image1Bytes = Files.readAllBytes(Paths.get("src/main/resources/canvas.jpg"));
        String image1 = Base64.getEncoder().encodeToString(image1Bytes);

        byte[] image2Bytes = Files.readAllBytes(Paths.get("src/main/resources/vk.jpg"));
        String image2 = Base64.getEncoder().encodeToString(image2Bytes);

        DragDrop captcha = new DragDrop();
        captcha.setBase64(background);
        captcha.setImages(Arrays.asList(image1, image2));
        captcha.setHintText("Drag the images to proper position");
        captcha.setLang("en");

        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

}
