package Gold5.Day174;

import java.io.*;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int value = findValueInsideParentheses(input);

        bw.write(String.valueOf(value));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findValueInsideParentheses(String input) {
        Stack<Character> stack = new Stack<>();

        int value = 0;
        int weight = 1;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
                weight *= ch == '(' ? 2 : 3;
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(' && ch == ')') {
                        if (input.charAt(i - 1) == '(')
                            value += weight;
                        weight /= 2;
                        stack.pop();
                    } else if (stack.peek() == '[' && ch == ']') {
                        if (input.charAt(i - 1) == '[')
                            value += weight;
                        weight /= 3;
                        stack.pop();
                    }
                } else {
                    value = 0;
                    break;
                }
            }
        }

        if (!stack.isEmpty())
            value = 0;

        return value;
    }
}
