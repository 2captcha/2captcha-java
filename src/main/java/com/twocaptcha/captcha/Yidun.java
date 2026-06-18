package com.twocaptcha.captcha;

public class Yidun extends Captcha {

    public Yidun() {
        super();
        params.put("method", "yidun");
    }

    public void setYidunGetLib(String yidunGetLib) {
        params.put("yidun_get_lib", yidunGetLib);
    }

    public void setYidunApiServerSubdomain(String yidunApiServerSubdomain) {
        params.put("yidun_api_server_subdomain", yidunApiServerSubdomain);
    }

    public void setChallenge(String challenge) {
        params.put("challenge", challenge);
    }

    public void setHcg(String hcg) {
        params.put("hcg", hcg);
    }

    public void setHct(Integer hct) {
        params.put("hct", java.lang.String.valueOf(hct));
    }
}