package com.mycompany;

import org.apache.commons.lang3.StringUtils;

public class HelloWorld {

    public void sayHello(String message) {
        System.out.println(message);
        if(StringUtils.isEmpty("ABCD")){
            System.out.println("String is empty");
        } else {
            System.out.println("String is not empty");
        }
    }
}
