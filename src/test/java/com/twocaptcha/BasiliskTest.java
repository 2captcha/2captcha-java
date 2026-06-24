package com.twocaptcha;

import com.twocaptcha.captcha.Basilisk;

import java.util.HashMap;
import java.util.Map;

public class BasiliskTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Basilisk captcha = new Basilisk();
        captcha.setSiteKey("b7890h...19fb2600897");
        captcha.setPageUrl("https://example.com/page-with-basilisk");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");

        Map<String, String> params = new HashMap<>();
        params.put("method", "basilisk");
        params.put("sitekey", "b7890h...19fb2600897");
        params.put("pageurl", "https://example.com/page-with-basilisk");
        params.put("useragent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}
