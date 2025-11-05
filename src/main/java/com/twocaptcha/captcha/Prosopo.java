package com.twocaptcha.captcha;

public class Prosopo extends Captcha {

    public Prosopo() {
        super();
        params.put("method", "prosopo");
    }

    public void setSiteKey(String siteKey) {
        params.put("sitekey", siteKey);
    }

    public void setUrl(String url) {
        params.put("pageurl", url);
    }

}
