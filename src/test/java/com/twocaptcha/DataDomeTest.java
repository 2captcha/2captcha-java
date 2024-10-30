package com.twocaptcha;

import com.twocaptcha.captcha.DataDome;

import java.util.HashMap;
import java.util.Map;

public class DataDomeTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        DataDome captcha = new DataDome();
        captcha.setCaptchaUrl("https://geo.captcha-delivery.com/captcha/?initialCid=AHrlqAAA...P~XFrBVptk&t=fe&referer=https%3A%2F%2Fhexample.com&s=45239&e=c538be..c510a00ea");
        captcha.setUrl("https://example.com/");
        captcha.setUserAgent("Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Mobile Safari/537.3");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        Map<String, String> params = new HashMap<>();
        params.put("method", "datadome");
        params.put("captcha_url", "https://geo.captcha-delivery.com/captcha/?initialCid=AHrlqAAA...P~XFrBVptk&t=fe&referer=https%3A%2F%2Fhexample.com&s=45239&e=c538be..c510a00ea");
        params.put("pageurl", "https://example.com/");
        params.put("userAgent", "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Mobile Safari/537.3");
        params.put("proxy", "login:password@IP_address:PORT");
        params.put("proxytype", "HTTPS");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }
}