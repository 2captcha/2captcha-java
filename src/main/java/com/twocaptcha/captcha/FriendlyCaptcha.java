package com.twocaptcha.captcha;

public class FriendlyCaptcha extends Captcha {

    public FriendlyCaptcha() {
        super();
        params.put("method", "friendly_captcha");
    }

    public void setSiteKey(String siteKey) {
        params.put("sitekey", siteKey);
    }

    public void setPageUrl(String url) {
        params.put("pageurl", url);
    }
}
//https://2captcha.com/in.php?F
// method=friendly_captcha&
// key=KEY&
// sitekey=FCMST5VUMCBOCGQ9&
// pageurl=https://geizhals.de/455973138?fsean=5901747021356