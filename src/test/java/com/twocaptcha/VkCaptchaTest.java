package com.twocaptcha;

import com.twocaptcha.captcha.VkCaptcha;
import com.twocaptcha.captcha.Yandex;

import java.util.HashMap;
import java.util.Map;

public class VkCaptchaTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        VkCaptcha captcha = new VkCaptcha("vkimage");
        captcha.setSiteKey("0x4AAAAAAAChNiVJM_WtShFf");
        captcha.setUrl("https://ace.fusionist.io");

        Map<String, String> params = new HashMap<>();
        params.put("method", "vkimage");
        params.put("sitekey", "0x4AAAAAAAChNiVJM_WtShFf");
        params.put("pageurl", "https://ace.fusionist.io");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}