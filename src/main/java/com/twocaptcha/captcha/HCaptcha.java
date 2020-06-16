package com.twocaptcha.captcha;

public class HCaptcha extends Captcha {

    public HCaptcha() {
        super();
        params.put("method", "hcaptcha");
    }

    public void setSiteKey(String siteKey) {
        params.put("sitekey", siteKey);
    }

    public void setUrl(String url) {
        params.put("pageurl", url);
    }

}
