package com.twocaptcha;

import com.twocaptcha.captcha.Tspd;

import java.util.HashMap;
import java.util.Map;

public class TspdTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Tspd captcha = new Tspd();
        captcha.setPageUrl("https://example.com/page-with-tspd");
        captcha.setTspdCookie("TS386a400d029=...");
        captcha.setHtmlPageBase64("PCFET0NUWVBFIGh0bWw+...");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        captcha.setProxy("HTTPS", "login:password@IP_address:PORT");

        Map<String, String> params = new HashMap<>();
        params.put("method", "tspd");
        params.put("pageurl", "https://example.com/page-with-tspd");
        params.put("tspd_cookie", "TS386a400d029=...");
        params.put("html_page_base64", "PCFET0NUWVBFIGh0bWw+...");
        params.put("userAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
        params.put("proxy", "login:password@IP_address:PORT");
        params.put("proxytype", "HTTPS");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}
