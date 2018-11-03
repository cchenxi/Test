package com.chenxi.test.language.aop;

public aspect LogAspect {
    pointcut logPointcut():execution(void SayHelloService.say());
    after():logPointcut(){
        System.out.println("记录日志 ...");
    }
}
