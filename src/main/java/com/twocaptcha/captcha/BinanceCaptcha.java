package com.twocaptcha.captcha;

public class BinanceCaptcha extends Captcha {

    public BinanceCaptcha() {
        super();
        params.put("method", "binance");
    }

    public void setValidateId(String validateId) {
        params.put("validate_id", validateId);
    }
}
