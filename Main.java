import java.util.*;
import java.io.*;
import util.*;

public class Main {
    static Lexer lexer = new Lexer();
    static List<String> algorithm = new ArrayList<String>();
    static List<Token> tokens = new ArrayList<Token>();

    public static void main(String[] args) throws Exception {
        init();

        for (String line : algorithm) {
            for (Token tk : lexer.tokenize(line))
                tk.repr();
            System.out.println();
        }
    }

    private static void init() throws Exception {
        // String cwd = System.getProperty("user.dir");
        // Scanner scan = new Scanner(System.in);
        // System.out.print("Enter file name: ");
        // String file = scan.nextLine();
        // loadAlg(cwd + "/emu/src/asm/" + file);
        // System.out.print("Enter memory size: ");
        // Memory.boot(scan.nextInt());
        // scan.nextLine();
        // System.out.print("Run in Debug mode (Y/n): ");
        // debug = scan.nextLine().equalsIgnoreCase("y");
        // scan.close();

        String filename = "test.alg";
        loadAlg(filename);
        Token.init();
    }

    static void loadAlg(String filepath, String filename) throws Exception {
        algorithm.clear();
        BufferedReader br = new BufferedReader(new FileReader(filepath + "\\" + filename));
        String line;
        while ((line = br.readLine()) != null)
            algorithm.add(line);
        br.close();
    }

    static void loadAlg(String filename) throws Exception {
        loadAlg("algorithms", filename);
    }
}
