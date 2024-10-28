package com.twocaptcha.captcha;

public class AtbCAPTCHA extends Captcha {

    public AtbCAPTCHA() {
        super();
        params.put("method", "atb_captcha");
    }

    public void setAppId(String appId) {
        params.put("app_id", appId);
    }

    public void setApiServer(String apiServer) {
        params.put("api_server", apiServer);
    }

    public void setPageUrl(String url) {
        params.put("pageurl", url);
    }
}