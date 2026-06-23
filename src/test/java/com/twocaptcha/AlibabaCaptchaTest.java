package com.twocaptcha;

import com.twocaptcha.captcha.AlibabaCaptcha;

import java.util.HashMap;
import java.util.Map;

public class AlibabaCaptchaTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        AlibabaCaptcha captcha = new AlibabaCaptcha();
        captcha.setSceneId("login");
        captcha.setPrefix("https://img.alicdn.com/tfs/...");
        captcha.setPageUrl("https://example.com/page-with-alibaba");

        Map<String, String> params = new HashMap<>();
        params.put("method", "alibaba");
        params.put("scene_id", "login");
        params.put("prefix", "https://img.alicdn.com/tfs/...");
        params.put("pageurl", "https://example.com/page-with-alibaba");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}
