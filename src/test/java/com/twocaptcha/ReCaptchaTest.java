package com.twocaptcha;

import com.twocaptcha.captcha.ReCaptcha;

import java.util.HashMap;
import java.util.Map;

public class ReCaptchaTest extends AbstractWrapperTestCase {

    public void testV2() throws Exception {
        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey("6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
        captcha.setUrl("https://mysite.com/page/with/recaptcha");
        captcha.setInvisible(true);
        captcha.setEnterprise(true);
        captcha.setAction("verify");
        captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36");
        captcha.setCookies("KEY1:Value1;KEY2:Value2;");

        Map<String, String> params = new HashMap<>();
        params.put("method", "userrecaptcha");
        params.put("googlekey", "6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
        params.put("pageurl", "https://mysite.com/page/with/recaptcha");
        params.put("invisible", "1");
        params.put("enterprise", "1");
        params.put("action", "verify");
        params.put("userAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36");
        params.put("cookies", "KEY1:Value1;KEY2:Value2;");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

    public void testV3() throws Exception {
        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey("6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
        captcha.setUrl("https://mysite.com/page/with/recaptcha");
        captcha.setVersion("v3");
        captcha.setEnterprise(true);
        captcha.setAction("verify");
        captcha.setScore(0.3);

        Map<String, String> params = new HashMap<>();
        params.put("method", "userrecaptcha");
        params.put("googlekey", "6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
        params.put("pageurl", "https://mysite.com/page/with/recaptcha");
        params.put("version", "v3");
        params.put("enterprise", "1");
        params.put("action", "verify");
        params.put("min_score", "0.3");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}