import java.util.*;
import util.*;
class Lexer {
    private String text;
    private int index, length;
    
    public List<Token> tokenize(String text) throws Exception {
        this.text = text;
        this.length = text.length();
        List<Token> tokens = new ArrayList<>();
        
        for (index = 0; index < length; index++) {
            char c = text.charAt(index);
            if (Character.isWhitespace(c)) continue;
            if (Character.isDigit(c)) {
                tokens.add(new Token("NUMBER", getNumber()));
            } else if (Token.symbols.containsKey(c)) {
                tokens.add(new Token(Token.symbols.get(c)));
            } else if (Character.isLetter(c)) {
                String word = getWord();
                tokens.add(new Token(Token.keywords.getOrDefault(word, "IDENTIFIER"), word));
            } else {
                throw new Exception("LEXER: Invalid Character " + c + " at pos " + index);
            }
        }
        return tokens;
    }
    
    private String getWord() {
        StringBuilder word = new StringBuilder();
        while (index < length && Character.isLetter(text.charAt(index))) {
            word.append(text.charAt(index++));
        }
        index--;
        return word.toString();
    }
    
    private String getNumber() {
        StringBuilder number = new StringBuilder();
        while (index < length && Character.isDigit(text.charAt(index))) {
            number.append(text.charAt(index++));
        }
        index--;
        return number.toString();
    }
}
