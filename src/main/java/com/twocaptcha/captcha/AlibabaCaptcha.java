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

    public void setUserId(String userId) { params.put("user_id", userId); }

    public void setUserUserId(String userUserId) { params.put("user_user_id", userUserId); }

    public void setVerifyType(String verifyType) { params.put("verify_type", verifyType); }

    public void setRegion(String region) { params.put("region", region); }

    public void setUserCertifyId(String userCertifyId) { params.put("user_certify_id", userCertifyId); }

    public void setApiGetLib(String apiGetLib) { params.put("api_get_lib", apiGetLib); }
}
