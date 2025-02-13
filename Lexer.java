
/*
 * A Lexer to Tokenize the given algorithm.
 */
import java.util.ArrayList;
import util.Token;

public class Lexer {
    private String text;
    private int index, length;

    private String getWord() {
        String word = "";
        for (char c; index < length && Character.isLetter(c = text.charAt(index)); index++) {
            word += c;
        }
        index--;
        return word;
    }

    private String getNum() {
        String num = "";
        for (char c; index < length && Character.isDigit(c = text.charAt(index)); index++) {
            num += c;
        }
        index--;
        return num;
    }

    public ArrayList<Token> tokenize(String t) throws Exception {
        text = t;
        length = text.length();
        ArrayList<Token> tokens = new ArrayList<Token>();
        Token token;
        char c;
        for (index = 0; index < length; index++) {
            c = text.charAt(index);
            if (c == '#') {
                token = new Token("Comment");
                break;
            } else if (c == ' ')
                continue;
            else if (Character.isDigit(c)) {
                token = new Token("NUMBER", getNum());
            } else if (Token.map.containsKey(c)) {
                token = new Token(Token.map.get(c));
            } else if (Character.isLetter(c)) {
                token = new Token("WORD", getWord());
            } else {
                token = new Token(null);
                throw new Exception("LEXER: Invalid Character " + c + " at pos " + index);
            }
            tokens.add(token);
        }
        return tokens;
    }
}
