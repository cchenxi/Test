package com.chenxi.test.spring;

import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
