package com.twocaptcha.captcha;

public class CloudflareChallenge extends Captcha {
    public CloudflareChallenge() {
        super();
        params.put("method", "challenge");
    }

    public void setSiteKey(String siteKey) {
        params.put("sitekey", siteKey);
    }

    public void setUrl(String url) {
        params.put("pageurl", url);
    }

    public void setAction(String action) {
        params.put("action", action);
    }

    public void setData(String data) {
        params.put("data", data);
    }

    public void setPagedata(String pagedata) {
        params.put("pagedata", pagedata);
    }

    public void setUserAgent(String userAgent) {
        params.put("userAgent", userAgent);
    }
}
