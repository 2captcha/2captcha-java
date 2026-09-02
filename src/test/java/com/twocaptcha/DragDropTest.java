package com.twocaptcha;

import com.twocaptcha.captcha.DragDrop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DragDropTest extends AbstractWrapperTestCase {

    public void testRequiredOptions() throws Exception {
        DragDrop captcha = new DragDrop();
        captcha.setBase64("BASE64_BACKGROUND");
        captcha.setImages(Arrays.asList("BASE64_IMAGE_1", "BASE64_IMAGE_2"));

        Map<String, String> params = new HashMap<>();
        params.put("method", "drag_drop");
        params.put("body", "BASE64_BACKGROUND");
        params.put("images", "[\"BASE64_IMAGE_1\",\"BASE64_IMAGE_2\"]");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

    public void testAllOptions() throws Exception {
        DragDrop captcha = new DragDrop();
        captcha.setBase64("BASE64_BACKGROUND");
        captcha.setImages(Arrays.asList("BASE64_IMAGE_1", "BASE64_IMAGE_2"));
        captcha.setHintText("Drag the images to proper position");
        captcha.setLanguage(1);
        captcha.setLang("en");

        Map<String, String> params = new HashMap<>();
        params.put("method", "drag_drop");
        params.put("body", "BASE64_BACKGROUND");
        params.put("images", "[\"BASE64_IMAGE_1\",\"BASE64_IMAGE_2\"]");
        params.put("textinstructions", "Drag the images to proper position");
        params.put("language", "1");
        params.put("lang", "en");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}
