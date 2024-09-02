package com.twocaptcha;

import com.twocaptcha.captcha.Tencent;

import java.util.HashMap;
import java.util.Map;

public class TencentTest extends AbstractWrapperTestCase {

    public void testAllOptions() throws Exception {
        Tencent tencent = new Tencent();
        tencent.setAppId("2092215077");
        tencent.setPageUrl("http://lcec.lclog.cn/cargo/NewCargotracking?blno=BANR01XMHB0004&selectstate=BLNO");

        Map<String, String> params = new HashMap<>();
        params.put("method", "tencent");
        params.put("app_id", "2092215077");
        params.put("pageurl", "http://lcec.lclog.cn/cargo/NewCargotracking?blno=BANR01XMHB0004&selectstate=BLNO");
        params.put("soft_id", "4581");
        params.put("json", "0");

        checkIfCorrectParamsSendAndResultReturned(tencent, params);
    }

}