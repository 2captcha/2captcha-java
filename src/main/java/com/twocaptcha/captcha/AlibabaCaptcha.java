package com.twocaptcha.captcha;

public class AlibabaCaptcha extends Captcha {

    public AlibabaCaptcha() {
        super();
        params.put("method", "alibaba");
    }

    public void setSceneId(String sceneId) {
        params.put("scene_id", sceneId);
    }

    public void setPrefix(String prefix) {
        params.put("prefix", prefix);
    }

}
