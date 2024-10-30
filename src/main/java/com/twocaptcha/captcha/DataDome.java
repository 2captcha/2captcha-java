package com.twocaptcha.captcha;

public class DataDome  extends Captcha {

    public DataDome() {
        super();
        params.put("method", "datadome");
    }

    public void setUrl(String url) {
        params.put("pageurl", url);
    }

    public void setCaptchaUrl(String capthaUrl)
    {
        params.put("captcha_url", capthaUrl);
    }

    public void setUserAgent(String userAgent) {
        params.put("userAgent", userAgent);
    }
}