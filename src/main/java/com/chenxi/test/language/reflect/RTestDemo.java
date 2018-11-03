package com.chenxi.test.language.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RTestDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //自描述
        Class clazz = Apple.class;
        final Constructor[] constructors = clazz.getConstructors();

        for (Constructor constructor : constructors) {
            System.out.println("constructor name = " + constructor.getName() +
            ", params length = " + constructor.getParameters().length);
        }

        final Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field name = " + field.getName());
        }

        final Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method name = " + method.getName());
        }

        //自控制
        Class appleClazz = Class.forName("com.chenxi.test.language.reflect.Apple");

        final Constructor constructor = appleClazz.getConstructor(String.class);
        final Object appleInstance = constructor.newInstance("china apple");
        System.out.println("is appleInstance equals Apple:" + (appleInstance instanceof Apple));

        final Apple chinaApple = (Apple) appleInstance;
        System.out.println("apple name = " + chinaApple.getName());

        final Method setNameMethod = appleClazz.getMethod("setName", String.class);
        setNameMethod.invoke(appleInstance, "china sd apple");
        System.out.println("apple name = " + chinaApple.getName());

        final Field nameField = appleClazz.getDeclaredField("name");

        nameField.setAccessible(true);
        nameField.set(appleInstance, "china sd app hfs");
        System.out.println("apple name" + chinaApple.getName());

        if (appleClazz.isAnnotationPresent(AppleDescription.class)) {
            AppleDescription appleDescription = (AppleDescription) appleClazz.getAnnotation(AppleDescription.class);
            System.out.println(
                    "apple class annotation is " + appleDescription.value()
            );
        }

        final Method getNameMethod = appleClazz.getMethod("getName");
        if (getNameMethod.isAnnotationPresent(AppleDescription.class)) {
            AppleDescription appleDescription = (AppleDescription) getNameMethod.getAnnotation(AppleDescription.class);
            System.out.println(
                    "getName method annotation is " + appleDescription.value()
            );
        }
    }
}
