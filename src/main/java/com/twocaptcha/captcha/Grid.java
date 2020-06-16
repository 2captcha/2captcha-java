package com.twocaptcha.captcha;

import java.io.File;

public class Grid extends Captcha {

    public Grid() {
        super();
    }

    public Grid(String filePath) {
        this(new File(filePath));
    }

    public Grid(File file) {
        this();
        setFile(file);
    }

    public void setFile(String filePath) {
        setFile(new File(filePath));
    }

    public void setFile(File file) {
        files.put("file", file);
    }

    public void setBase64(String base64) {
        params.put("body", base64);
    }

    public void setRows(int rows) {
        params.put("recaptcharows", String.valueOf(rows));
    }

    public void setCols(int cols) {
        params.put("recaptchacols", String.valueOf(cols));
    }

    public void setPreviousId(int previousId) {
        params.put("previousID", String.valueOf(previousId));
    }

    public void setCanSkip(boolean canSkip) {
        params.put("can_no_answer", canSkip ? "1" : "0");
    }

    public void setLang(String lang) {
        params.put("lang", lang);
    }

    public void setHintText(String hintText) {
        params.put("textinstructions", hintText);
    }

    public void setHintImg(String base64) {
        params.put("imginstructions", base64);
    }

    public void setHintImg(File hintImg) {
        files.put("imginstructions", hintImg);
    }

}
