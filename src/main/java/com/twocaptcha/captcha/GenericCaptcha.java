package com.twocaptcha.captcha;

import java.util.Map;

public class GenericCaptcha extends Captcha {

    public GenericCaptcha() {
        super();
    }

    public void setParams(Map<String, String> params){
        this.params = params;
    }
}
