package com.idea.realize.javacore36.lambda;

@FunctionalInterface
interface Index {
    int index(String subString);
}

@FunctionalInterface
interface Generator {
    String generate();
}

public class HelloWorld {
    static int getIndex(Index t, String subString) {
        return t.index(subString);
    }

    static String generateString(Generator g) {
        return g.generate();
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(getIndex(str::indexOf, "e"));
        System.out.println(generateString(String::new).length());
    }
}