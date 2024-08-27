package com.twocaptcha;

import com.twocaptcha.captcha.FriendlyCaptcha;
import com.twocaptcha.captcha.Lemin;

import java.util.HashMap;
import java.util.Map;

public class FriendlyCaptchaTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        FriendlyCaptcha friendlyCaptcha = new FriendlyCaptcha();
        friendlyCaptcha.setSiteKey("FCMST5VUMCBOCGQ9");
        friendlyCaptcha.setPageUrl("https://geizhals.de/455973138?fsean=5901747021356");

        Map<String, String> params = new HashMap<>();
        params.put("method", "friendly_captcha");
        params.put("sitekey", "FCMST5VUMCBOCGQ9");
        params.put("pageurl", "https://geizhals.de/455973138?fsean=5901747021356");
        params.put("soft_id", "4581");
        params.put("json", "1");

        checkIfCorrectParamsSendAndResultReturned(friendlyCaptcha, params);
    }

}