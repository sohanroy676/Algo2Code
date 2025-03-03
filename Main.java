import java.util.*;
import java.io.*;
import util.*;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        String filename = "test.alg";
        StringBuilder algorithm = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("algorithms/" + filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                algorithm.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        List<Token> tokens;
        try {
            tokens = lexer.tokenize(algorithm.toString().trim());
            System.out.println("Tokens: " + tokens);
            String pythonCode = Translator.translateToPython(tokens);
            System.out.println("Python Code: \n" + pythonCode);
            String complexity = CompAnalysis.analyzeTimeComplexity(tokens);
            System.out.println("Estimated Time Complexity: " + complexity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
