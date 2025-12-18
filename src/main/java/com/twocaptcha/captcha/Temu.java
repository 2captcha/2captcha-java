package com.twocaptcha.captcha;

public class Temu extends Captcha {

    public Temu() {
        super();
        params.put("method", "temuimage");
    }

    public void setBody(String body) {
        params.put("body", body);
    }
    public void setPart1(String part1) {
        params.put("part1", part1);
    }
    public void setPart2(String part2) {
        params.put("part2", part2);
    }
    public void setPart3(String part3) {
        params.put("part3", part3);
    }
}
