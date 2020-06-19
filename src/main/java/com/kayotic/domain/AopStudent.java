package com.kayotic.domain;

import org.springframework.stereotype.Component;

@Component("student")
public class AopStudent {

    private String name = "Wim";

    public String getName() {
        return name;
    }

}
