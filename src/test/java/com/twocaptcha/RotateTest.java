package com.twocaptcha;

import com.twocaptcha.captcha.Rotate;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotateTest extends AbstractWrapperTestCase {

    private final String[] captchaImgPaths = {
            "src/main/resources/rotate.jpg",
            "src/main/resources/rotate_2.jpg",
            "src/main/resources/rotate_3.jpg",
    };

    private final String hintImgPath = "src/main/resources/grid_hint.jpg";
    private final String hintText = "Put the images in the correct way up";

    public void testSingleFile() throws Exception {
        File image = new File(captchaImgPaths[0]);

        Rotate captcha = new Rotate(image);

        Map<String, String> params = new HashMap<>();
        params.put("method", "rotatecaptcha");

        Map<String, File> files = new HashMap<>();
        files.put("file_1", image);

        checkIfCorrectParamsSendAndResultReturned(captcha, params, files);
    }

    public void testSingleFileParameter() throws Exception {
        File image = new File(captchaImgPaths[0]);

        Rotate captcha = new Rotate();
        captcha.setFile(image);

        Map<String, String> params = new HashMap<>();
        params.put("method", "rotatecaptcha");

        Map<String, File> files = new HashMap<>();
        files.put("file_1", image);

        checkIfCorrectParamsSendAndResultReturned(captcha, params, files);
    }

    public void testFilesList() throws Exception {
        List<File> images = getImages();

        Rotate captcha = new Rotate(images);

        Map<String, String> params = new HashMap<>();
        params.put("method", "rotatecaptcha");

        Map<String, File> files = new HashMap<>();
        files.put("file_1", images.get(0));
        files.put("file_2", images.get(1));
        files.put("file_3", images.get(2));

        checkIfCorrectParamsSendAndResultReturned(captcha, params, files);
    }

    public void testFilesListParameter() throws Exception {
        List<File> images = getImages();

        Rotate captcha = new Rotate();
        captcha.setFiles(images);

        Map<String, String> params = new HashMap<>();
        params.put("method", "rotatecaptcha");

        Map<String, File> files = new HashMap<>();
        files.put("file_1", images.get(0));
        files.put("file_2", images.get(1));
        files.put("file_3", images.get(2));

        checkIfCorrectParamsSendAndResultReturned(captcha, params, files);
    }

    public void testAllParameters() throws Exception {
        File image = new File(captchaImgPaths[0]);
        File hintImg = new File(hintImgPath);

        Rotate captcha = new Rotate();
        captcha.setFile(image);
        captcha.setAngle(45);
        captcha.setLang("en");
        captcha.setHintImg(hintImg);
        captcha.setHintText(hintText);

        Map<String, String> params = new HashMap<>();
        params.put("method", "rotatecaptcha");
        params.put("angle", "45.0");
        params.put("lang", "en");
        params.put("textinstructions", hintText);

        Map<String, File> files = new HashMap<>();
        files.put("file_1", image);
        files.put("imginstructions", hintImg);

        checkIfCorrectParamsSendAndResultReturned(captcha, params, files);
    }

    private List<File> getImages() {
        List<File> images = new ArrayList<>();

        for (String image : captchaImgPaths) {
            images.add(new File(image));
        }

        return images;
    }

}