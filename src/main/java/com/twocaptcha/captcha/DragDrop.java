package com.twocaptcha.captcha;

import org.json.JSONArray;

import java.util.List;

public class DragDrop extends Captcha {

    public DragDrop() {
        super();
        params.put("method", "drag_drop");
    }

    public void setBase64(String base64) {
        params.put("body", base64);
    }

    public void setImages(List<String> images) {
        params.put("images", new JSONArray(images).toString());
    }

    public void setHintText(String hintText) {
        params.put("textinstructions", hintText);
    }

    public void setLanguage(int language) {
        params.put("language", String.valueOf(language));
    }

    public void setLang(String lang) {
        params.put("lang", lang);
    }

}
