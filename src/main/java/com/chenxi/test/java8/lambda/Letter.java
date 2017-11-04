package com.chenxi.test.java8.lambda;

import java.util.function.Function;

/**
 * TODO: description
 * Date: 2017-11-01
 *
 * @author chenxi
 */
public class Letter {
    public static String addHeader(String text) {
        return "from a, b and c: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    public static void main(String[] args) {

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        String result = transformationPipeline.apply("primary.setDepartDateBegin(queryHotelRoomsParam.getStartDepartsDate())");
        System.out.println(result);
    }
}
