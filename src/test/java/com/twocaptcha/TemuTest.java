package com.twocaptcha;

import com.twocaptcha.captcha.Temu;

import java.util.HashMap;
import java.util.Map;

public class TemuTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Temu captcha = new Temu();
        captcha.setBody("body");
        captcha.setPart1("part1");
        captcha.setPart2("part2");
        captcha.setPart3("part3");

        Map<String, String> params = new HashMap<>();
        params.put("method", "temuimage");
        params.put("body", "body");
        params.put("part1", "part1");
        params.put("part2", "part2");
        params.put("part3", "part3");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}