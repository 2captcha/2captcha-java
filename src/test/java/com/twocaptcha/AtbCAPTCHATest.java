package com.twocaptcha;

import com.twocaptcha.captcha.AtbCAPTCHA;
import com.twocaptcha.captcha.Capy;

import java.util.HashMap;
import java.util.Map;

public class AtbCAPTCHATest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        AtbCAPTCHA captcha = new AtbCAPTCHA();
        captcha.setAppId("af23e041b22d000a11e22a230fa8991c");
        captcha.setPageUrl("https://www.playzone.vip/");
        captcha.setApiServer("https://cap.aisecurius.com");

        Map<String, String> params = new HashMap<>();
        params.put("method", "atb_captcha");
        params.put("app_id", "af23e041b22d000a11e22a230fa8991c");
        params.put("pageurl", "https://www.playzone.vip/");
        params.put("api_server","https://cap.aisecurius.com");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}