package com.twocaptcha;

import com.twocaptcha.captcha.Prosopo;

import java.util.HashMap;
import java.util.Map;

public class ProsopoTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Prosopo captcha = new Prosopo();
        captcha.setSiteKey("5EZVvsHMrKCFKp5NYNoTyDjTjetoVo1Z4UNNbTwJf1GfN6Xm");
        captcha.setUrl("https://www.twickets.live/");

        Map<String, String> params = new HashMap<>();
        params.put("method", "prosopo");
        params.put("sitekey", "5EZVvsHMrKCFKp5NYNoTyDjTjetoVo1Z4UNNbTwJf1GfN6Xm");
        params.put("pageurl", "https://www.twickets.live/");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}