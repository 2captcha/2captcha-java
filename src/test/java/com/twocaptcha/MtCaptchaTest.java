package com.twocaptcha;

import com.twocaptcha.captcha.MtCaptcha;

import java.util.HashMap;
import java.util.Map;

public class MtCaptchaTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        MtCaptcha mtCaptcha = new MtCaptcha();
        mtCaptcha.setSiteKey("MTPublic-KzqLY1cKH");
        mtCaptcha.setPageUrl("https://2captcha.com/demo/mtcaptcha");

        Map<String, String> params = new HashMap<>();
        params.put("method", "mt_captcha");
        params.put("sitekey", "MTPublic-KzqLY1cKH");
        params.put("pageurl", "https://2captcha.com/demo/mtcaptcha");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(mtCaptcha, params);
    }

}