package com.twocaptcha;

import com.twocaptcha.captcha.BinanceCaptcha;
import com.twocaptcha.captcha.Yandex;

import java.util.HashMap;
import java.util.Map;

public class BinanceCaptchaTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        BinanceCaptcha captcha = new BinanceCaptcha();
        captcha.setSiteKey("login");
        captcha.setPageUrl("https://example.com/page-with-binance");
        captcha.setValidateId("cb0bfef...e54ecd57b");

        Map<String, String> params = new HashMap<>();
        params.put("method", "binance");
        params.put("sitekey", "login");
        params.put("pageurl", "https://example.com/page-with-binance");
        params.put("validate_id", "cb0bfef...e54ecd57b");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}