import java.util.*;
import util.*;

class Translator {
    public static String translateToPython(List<Token> tokens) {
        StringBuilder pythonCode = new StringBuilder();
        int indentLevel = 0; 
        String indent = "    "; // 4 spaces per level
        boolean newLine = true; 
        for (Token token : tokens) {
            if (newLine) {
                pythonCode.append(indent.repeat(indentLevel)); // Apply indentation at the start of a new line
                newLine = false;
            }

            switch (token.type) {
                case "FUNCTION":
                    pythonCode.append("def ");
                    break;
                case "IDENTIFIER":
                case "NUMBER":
                    pythonCode.append(token.value).append(" ");
                    break;
                case "EQUALS":
                    pythonCode.append("= ");
                    break;
                case "PLUS":
                    pythonCode.append("+ ");
                    break;
                case "MINUS":
                    pythonCode.append("- ");
                    break;
                case "MULTIPLY":
                    pythonCode.append("* ");
                    break;
                case "DIVIDE":
                    pythonCode.append("/ ");
                    break;
                case "PARENTHESES_OPEN":
                    pythonCode.append("(");
                    break;
                case "PARENTHESES_CLOSE":
                    pythonCode.append(")");
                    break;
                case "BRACE_OPEN":
                    pythonCode.append(":\n"); // `{` replaced with `:`
                    indentLevel++; // Increase indentation
                    newLine = true; 
                    break;
                case "BRACE_CLOSE":
                    indentLevel = Math.max(0, indentLevel - 1); // Decrease indentation
                    pythonCode.append("\n").append(indent.repeat(indentLevel)); // Ensure indentation reduction
                    newLine = true;
                    break;
                case "SEMICOLON":
                    pythonCode.append("\n"); // Ensure proper line breaks
                    newLine = true; // Set flag for indentation in next line
                    break;
                case "RETURN":
                    //System.out.println(indentLevel);
                    pythonCode.append("return ");
                    newLine = false;
                    break;
                default:
                    pythonCode.append(token.value).append(" ");
                    break;
            }
        }

        // Remove trailing blank lines for clean formatting
        return pythonCode.toString().replaceAll("\n{2,}", "\n").trim();
    }
}
