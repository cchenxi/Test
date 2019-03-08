package com.chenxi.test.language.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @link {https://javahungry.blogspot.com/2013/12/first-non-repeated-character-in-string-java-program-code-example.html}
 */
public class FirstNonRepeated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        f1(input);
        f2(input);
    }

    public static void f1(String input) {
        for (char c : input.toCharArray()) {
            if (input.indexOf(c) == input.lastIndexOf(c)) {
                System.out.println(c);
                break;
            }
        }
    }

    public static void f2(String input) {
        Map<Character, Integer> set = new HashMap<>();
        Character c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (set.containsKey(c)) {
                set.put(c, set.get(c) + 1);
            } else {
                set.put(c, 1);
            }
        }

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (set.get(c) == 1) {
                System.out.println(c);
                return;
            }
        }
    }
}
