package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.Stack;

public class BOJ4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while (!(line = br.readLine()).equals(".")) {
            boolean pass = isBalanced(line);

            bw.write(pass ? "yes\n" : "no\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isBalanced(String line) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                char prevCh = !stack.isEmpty() ? stack.pop() : ' ';

                if ((ch == ')' && prevCh != '(') || (ch == ']' && prevCh != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
