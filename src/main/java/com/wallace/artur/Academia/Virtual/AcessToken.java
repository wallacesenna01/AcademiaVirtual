package com.wallace.artur.Academia.Virtual;

import org.springframework.stereotype.Component;

@Component
public class AcessToken {

    private String AcessToken;

    public AcessToken(String acessToken) {
        AcessToken = acessToken;
    }

    public String getAcessToken() {
        return AcessToken;
    }

    public void setAcessToken(String acessToken) {
        AcessToken = acessToken;
    }
}
