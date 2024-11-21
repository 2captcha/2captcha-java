package com.twocaptcha;

import com.twocaptcha.captcha.Capy;
import com.twocaptcha.captcha.Cutcaptcha;

import java.util.HashMap;
import java.util.Map;

public class CutcaptchaTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Cutcaptcha cutcaptcha = new Cutcaptcha();
        cutcaptcha.setMiseryKey("a1488b66da00bf332a1488993a5443c79047e752");
        cutcaptcha.setUrl("https://filecrypt.co/Container/237D4D0995.html");
        cutcaptcha.setDataApiKey("SAb83IIB");

        Map<String, String> params = new HashMap<>();
        params.put("method", "cutcaptcha");
        params.put("misery_key", "a1488b66da00bf332a1488993a5443c79047e752");
        params.put("pageurl", "https://filecrypt.co/Container/237D4D0995.html");
        params.put("api_key","SAb83IIB");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(cutcaptcha, params);
    }

}