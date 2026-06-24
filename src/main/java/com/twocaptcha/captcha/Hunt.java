package com.twocaptcha.captcha;

public class Hunt extends Captcha {

    public Hunt() {
        super();
        params.put("method", "hunt");
    }

    public void setApiGetLib(String apiGetLib) {
        params.put("api_get_lib", apiGetLib);
    }

    public void setData(String data) {
        params.put("data", data);
    }

}
