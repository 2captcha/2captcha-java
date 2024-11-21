package com.twocaptcha;

import com.twocaptcha.captcha.Lemin;

import java.util.HashMap;
import java.util.Map;

public class LeminTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Lemin captcha = new Lemin();
        captcha.setСaptchaId("CROPPED_d3d4d56_73ca4008925b4f83a8bed59c2dd0df6d");
        captcha.setUrl("https://mysite.com/page/with/LeminCaptcha");
        captcha.setApiServer("api.leminnow.com");


        Map<String, String> params = new HashMap<>();
        params.put("method", "lemin");
        params.put("captcha_id", "CROPPED_d3d4d56_73ca4008925b4f83a8bed59c2dd0df6d");
        params.put("pageurl", "https://mysite.com/page/with/LeminCaptcha");
        params.put("api_server", "api.leminnow.com");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}