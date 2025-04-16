package com.wallace.artur.Academia.Virtual;

import org.springframework.stereotype.Component;


public class AcessToken {

    private String acessToken;

    public AcessToken(String acessToken) {
        this.acessToken = acessToken;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
    }
}
