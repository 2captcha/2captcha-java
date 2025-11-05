package com.twocaptcha;

import com.twocaptcha.captcha.Prosopo;

import java.util.HashMap;
import java.util.Map;

public class ProsopoTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Prosopo captcha = new Prosopo();
        captcha.setSiteKey("5EPQoMZEDc5LpN7gtxMMzYPTzA6UeWqL2stk1rso9gy4Ahqt");
        captcha.setUrl("https://www.example.com/");

        Map<String, String> params = new HashMap<>();
        params.put("method", "prosopo");
        params.put("sitekey", "5EPQoMZEDc5LpN7gtxMMzYPTzA6UeWqL2stk1rso9gy4Ahqt");
        params.put("pageurl", "https://www.example.com/");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}