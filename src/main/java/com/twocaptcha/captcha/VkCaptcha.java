package com.twocaptcha.captcha;

public class VkCaptcha extends Captcha {

    public VkCaptcha(String method) {
        super();
        params.put("method", method);
    }

    public void setSteps(String steps) {
        params.put("steps", steps);
    }

    public void setImageBase64(String imageBase64) {
        params.put("body", imageBase64);
    }

    public void setRedirectUri(String redirect_uri) {
        params.put("redirect_uri", redirect_uri);
    }

    public void setuserAgent(String userAgent) {
        params.put("userAgent", userAgent);
    }


}
