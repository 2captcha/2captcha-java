package com.twocaptcha.captcha;

public class VkCaptcha extends Captcha {

    public VkCaptcha() {
        super();
        params.put("method", "vkimage");
    }

    public void setSteps(String steps) {
        params.put("steps", steps);
    }

    public void setImageBase64(String imageBase64) {
        params.put("body", imageBase64);
    }
}
