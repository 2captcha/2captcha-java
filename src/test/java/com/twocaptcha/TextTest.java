package com.twocaptcha;

import com.twocaptcha.captcha.Text;

import java.util.HashMap;
import java.util.Map;

public class TextTest extends AbstractWrapperTestCase {

    private final String question = "Today is monday?";

    public void testSimpleText() throws Exception {
        Text captcha = new Text(question);

        Map<String, String> params = new HashMap<>();
        params.put("method", "post");
        params.put("textcaptcha", question);

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

    public void testTextParameter() throws Exception {
        Text captcha = new Text();
        captcha.setText(question);

        Map<String, String> params = new HashMap<>();
        params.put("method", "post");
        params.put("textcaptcha", question);

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

    public void testAllParameters() throws Exception {
        Text captcha = new Text();
        captcha.setText(question);
        captcha.setLang("en");

        Map<String, String> params = new HashMap<>();
        params.put("method", "post");
        params.put("textcaptcha", question);
        params.put("lang", "en");

        checkIfCorrectParamsSendAndResultReturned(captcha, params);
    }

}