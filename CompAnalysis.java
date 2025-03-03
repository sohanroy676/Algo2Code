import java.util.*;
import util.*;

class CompAnalysis{
    public static String analyzeTimeComplexity(List<Token> tokens) {
        int loops = 0;
        int nestedLoops = 0;
        Stack<String> loopStack = new Stack<>();
        
        for (Token token : tokens) {
            if (token.type.equals("FOR") || token.type.equals("WHILE")) {
                loops++;
                loopStack.push("loop");
            }
            if (token.type.equals("BRACE_CLOSE") && !loopStack.isEmpty()) {
                loopStack.pop();
                if (!loopStack.isEmpty()) {
                    nestedLoops++;
                }
            }
        }
        if(loops==0) return "O(n^0)";
        return "O(n^" + (nestedLoops + 1) + ")";
    }
}
