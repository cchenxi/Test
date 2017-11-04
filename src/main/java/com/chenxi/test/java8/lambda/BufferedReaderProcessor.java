package com.chenxi.test.java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO: description
 * Date: 2017-10-30
 *
 * @author chenxi
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}
