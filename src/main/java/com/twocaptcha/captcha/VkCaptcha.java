package com.twocaptcha.captcha;

public class VkCaptcha extends Captcha {

    public VkCaptcha() {
        super();
        params.put("method", "VKCaptchaImageTask");
    }
}
