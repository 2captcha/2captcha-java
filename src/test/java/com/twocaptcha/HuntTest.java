package com.twocaptcha;

import com.twocaptcha.captcha.Hunt;

import java.util.HashMap;
import java.util.Map;

public class HuntTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Hunt captcha = new Hunt();
        captcha.setPageUrl("https://example.com/page-with-hunt");
        captcha.setApiGetLib("https://example.com/api.js");
        captcha.setData("meta.token.value");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        Map<String, String> params = new HashMap<>();
        params.put("method", "hunt");
        params.put("pageurl", "https://example.com/page-with-hunt");
        params.put("api_get_lib", "https://example.com/api.js");
        params.put("data", "meta.token.value");
        params.put("userAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        params.put("proxy", "login:password@IP_address:PORT");
        params.put("proxytype", "HTTPS");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}
