package com.chenxi.test.language.reflect;

@AppleDescription("this ia a apple annotation")
public class Apple {
    private String name;

    public Apple() {

    }

    public Apple(String name) {
        this.name = name;
    }

    @AppleDescription("this is an apple annotation 2")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
