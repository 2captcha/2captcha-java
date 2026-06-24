package com.twocaptcha.captcha;

public class Tspd extends Captcha {

    public Tspd() {
        super();
        params.put("method", "tspd");
    }

    public void setTspdCookie(String tspdCookie) {
        params.put("tspd_cookie", tspdCookie);
    }

    public void setHtmlPageBase64(String htmlPageBase64) {
        params.put("html_page_base64", htmlPageBase64);
    }
}
