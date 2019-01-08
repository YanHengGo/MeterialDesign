package com.yanheng.activityfragmentinterface.bean;

import java.io.Serializable;

public class WebInfo implements Serializable {
    private String url;
    private String name;

    public WebInfo(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
