package com.chenxi.test.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MessageService myMessageService() {
        return new MessageServiceImpl();
    }
}
