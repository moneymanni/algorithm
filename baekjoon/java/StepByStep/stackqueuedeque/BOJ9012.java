package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.Stack;

public class BOJ9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();

            boolean isVps = isVPS(input);

            bw.write(isVps ? "YES\n" : "NO\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                char prevCh = !stack.isEmpty() ? stack.pop() : ' ';

                if (prevCh != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
