package Gold4.Day192;

import java.io.*;
import java.util.Stack;

public class BOJ9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bombStr = br.readLine();

        bw.write(explodeString(str, bombStr));

        br.close();
        bw.flush();
        bw.close();
    }

    private static String explodeString(String str, String bombStr) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            stack.push(ch);

            if (stack.size() >= bombStr.length() && check(stack, bombStr)) {
                for (int j = 0; j < bombStr.length(); j++)
                    stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : stack)
            sb.append(ch);

        return sb.length() == 0 ? "FRULA" : sb.toString();
    }

    private static boolean check(Stack<Character> stack, String bombStr) {
        for (int i = 0; i < bombStr.length(); i++) {
            if (stack.get(stack.size() - bombStr.length() + i) != bombStr.charAt(i))
                return false;
        }

        return true;
    }
}
