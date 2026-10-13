package com.twocaptcha.captcha;

public class Imperva extends Captcha {

    public Imperva() {
        super();
        params.put("method", "incapsula");
    }

    public void setIncapsulaScriptUrl(String incapsulaScriptUrl) {
        params.put("incapsula_script_url", incapsulaScriptUrl);
    }

    public void setIncapsulaCookies(String incapsulaCookies) {
        params.put("incapsula_cookies", incapsulaCookies);
    }

    public void setReese84UrlEndpoint(String reese84UrlEndpoint) {
        params.put("reese84_url_endpoint", reese84UrlEndpoint);
    }
}
