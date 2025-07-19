package StepByStep.stackqueuedeque2;

import java.io.*;
import java.util.Stack;

public class BOJ9935 {

    private final static String EMPTY = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        String result = explode(str, bomb);

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static String explode(String str, String bomb) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            stack.push(ch);

            if (stack.size() >= bomb.length() && check(stack, bomb)) {
                for (int j = 0; j < bomb.length(); j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.length() == 0 ? EMPTY : sb.toString();
    }

    private static boolean check(Stack<Character> stack, String bomb) {
        for (int i = 0; i < bomb.length(); i++) {
            if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}
