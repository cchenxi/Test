package com.chenxi.test.language.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @link {https://javahungry.blogspot.com/2014/11/string-has-all-unique-characters-java-example.html}
 * @link {https://stackoverflow.com/questions/19484406/detecting-if-a-string-has-unique-characters-comparing-my-solution-to-cracking}
 */
public class DetermineStringAllUnique {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        f1(input);
        f2(input);
        f3(input);
        f4(input);
    }

    public static void f1(String input) {
        boolean result = true;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            result = set.add(input.charAt(i));
            if (!result)
                break;
        }
        System.out.println(result);
    }

    public static void f2(String input) {
        boolean result = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int count = 0;
            for (int j = i + 1; j < input.length(); j++) {
                if (c == input.charAt(j))
                    count++;
            }
            if (count > 0) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }

    public static void f3(String input) {
        boolean result = true;
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            //indexOf(), indexOf() which returns the index of first occurence of the character in the string
            indexes.add(input.indexOf(input.charAt(i)));
        }
        Collections.sort(indexes);

        for (int i = 0; i < indexes.size() - 1; i++) {
            if (indexes.get(i).equals(indexes.get(i + 1))) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }

    public static void f4(String input) {
        boolean result = true;
        for (char c : input.toCharArray()) {
            //lastIndexOf(),lastIndexOf() returns the index of last occurence of the character in the given string
            if (input.indexOf(c) != input.lastIndexOf(c)) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
