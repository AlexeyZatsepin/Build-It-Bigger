package com.study.backend.joker.beans;

import study.gradlecoursefinalproject.ContentProvider;

/**
 * The object model for the data we are sending through endpoints
 */
public class Bean {

    protected String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static Bean buildJoke(){
        Bean bean = new Bean();
        bean.setData(ContentProvider.getJoke());
        return bean;
    }
}