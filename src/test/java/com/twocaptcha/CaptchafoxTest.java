package com.twocaptcha;

import com.twocaptcha.captcha.Captchafox;
import com.twocaptcha.captcha.Turnstile;

import java.util.HashMap;
import java.util.Map;

public class CaptchafoxTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Captchafox captcha = new Captchafox();
        captcha.setSiteKey("sk_ILKWNruBBVKDOM7dZs59KHnDLEWiH");
        captcha.setUrl("https://mysite.com/page/with/captchafox");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36");

        Map<String, String> params = new HashMap<>();
        params.put("method", "captchafox");
        params.put("sitekey", "sk_ILKWNruBBVKDOM7dZs59KHnDLEWiH");
        params.put("pageurl", "https://mysite.com/page/with/captchafox");
        params.put("userAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}