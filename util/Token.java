package util;

import java.util.*;

public class Token {
    public String type, value;
    public static Map<Character, String> symbols = new HashMap<>();
    public static Map<String, String> keywords = new HashMap<>();

    public Token(String t, String v) {
        type = t;
        value = v;
    }

    public Token(String t) {
        type = t;
        value = null;
    }

    public void repr() {
        System.out.print(String.format("<%s:%s> ", type, value));
    }

    public static void init() {
        Token.symbols.put(',', "COMMA");
        Token.symbols.put('+', "PLUS");
        Token.symbols.put('=', "EQUALS");
        Token.symbols.put(';', "SEMICOLON");
        Token.symbols.put('[', "BRACKET_OPEN");
        Token.symbols.put(']', "BRACKET_CLOSE");
        Token.symbols.put('(', "PARANTHESES_OPEN");
        Token.symbols.put(')', "PARANTHESES_CLOSE");
        Token.symbols.put('{', "BRACE_OPEN");
        Token.symbols.put('}', "BRACE_CLOSE");

        // Token.keywords.put("if", "");
        // Token.keywords.put();
        // Token.keywords.put();
    }
}
