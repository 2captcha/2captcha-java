package com.twocaptcha;

import com.twocaptcha.captcha.Yidun;

import java.util.HashMap;
import java.util.Map;

public class YidunTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Yidun captcha = new Yidun();
        captcha.setSiteKey("0f743r3g1...8rz3grz0ym5");
        captcha.setPageUrl("https://example.com/page-with-yidun");

        Map<String, String> params = new HashMap<>();
        params.put("method", "yidun");
        params.put("sitekey", "0f743r3g1...8rz3grz0ym5");
        params.put("pageurl", "https://example.com/page-with-yidun");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}