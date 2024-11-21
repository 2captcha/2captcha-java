package com.twocaptcha.captcha;

public class Cybersiara  extends Captcha {

    public Cybersiara() {
        super();
        params.put("method", "cybersiara");
    }

    public void setMasterUrlId(String masterUrlId)
    {
        params.put("master_url_id", masterUrlId);
    }

    public void setUrl(String url) {
        params.put("pageurl", url);
    }

    public void setUserAgent(String userAgent) {
        params.put("userAgent", userAgent);
    }
}