package com.twocaptcha.captcha;

public class Cutcaptcha extends Captcha {

    public Cutcaptcha() {
        super();
        params.put("method", "cutcaptcha");
    }

    public void setMiseryKey(String miseryKey) {
        params.put("misery_key", miseryKey);
    }

    public void setUrl(String url) {
        params.put("pageurl", url);
    }

    public void setDataApiKey(String dataApiKey) {
        params.put("api_key", dataApiKey);
    }

}