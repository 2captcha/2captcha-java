package com.twocaptcha.captcha;

public class Captchafox extends Captcha {

    public Captchafox() {
        super();
        params.put("method", "captchafox");
    }

    public void setSiteKey(String siteKey) {
        params.put("sitekey", siteKey);
    }

    public void setUrl(String url) {
        params.put("pageurl", url);
    }

}
