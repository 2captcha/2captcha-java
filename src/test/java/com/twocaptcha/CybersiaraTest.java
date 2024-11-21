package com.twocaptcha;

import com.twocaptcha.captcha.Cybersiara;

import java.util.HashMap;
import java.util.Map;

public class CybersiaraTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Cybersiara captcha = new Cybersiara();
        captcha.setMasterUrlId("tpjOCKjjpdzv3d8Ub2E9COEWKt1vl1Mv");
        captcha.setUrl("https://demo.mycybersiara.com/");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

        Map<String, String> params = new HashMap<>();
        params.put("method", "cybersiara");
        params.put("master_url_id", "tpjOCKjjpdzv3d8Ub2E9COEWKt1vl1Mv");
        params.put("pageurl", "https://demo.mycybersiara.com/");
        params.put("userAgent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }
}