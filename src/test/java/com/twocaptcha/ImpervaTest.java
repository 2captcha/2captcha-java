package com.twocaptcha;

import com.twocaptcha.captcha.Imperva;

import java.util.HashMap;
import java.util.Map;

public class ImpervaTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Imperva captcha = new Imperva();
        captcha.setPageUrl("https://example.com/login");
        captcha.setIncapsulaScriptUrl("/_Incapsula_Resource?SWUDNSAI=31&xinfo=1");
        captcha.setIncapsulaCookies("visid_incap_123456=sample; incap_ses_123_123456=sample");
        captcha.setReese84UrlEndpoint("https://example.com/_Incapsula_Resource?reese84=1");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        captcha.setProxy("HTTP", "login:password@IP_address:PORT");

        Map<String, String> params = new HashMap<>();
        params.put("method", "incapsula");
        params.put("pageurl", "https://example.com/login");
        params.put("incapsula_script_url", "/_Incapsula_Resource?SWUDNSAI=31&xinfo=1");
        params.put("incapsula_cookies", "visid_incap_123456=sample; incap_ses_123_123456=sample");
        params.put("reese84_url_endpoint", "https://example.com/_Incapsula_Resource?reese84=1");
        params.put("userAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        params.put("proxy", "login:password@IP_address:PORT");
        params.put("proxytype", "HTTP");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}
