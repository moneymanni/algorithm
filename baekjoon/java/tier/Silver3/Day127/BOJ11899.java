package Silver3.Day127;

import java.io.*;
import java.util.Stack;

public class BOJ11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (!stack.isEmpty() && ch == ')' && stack.peek() == '(')
                stack.pop();
            else
                stack.push(ch);
        }

        bw.write(stack.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
