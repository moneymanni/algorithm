package Silver4.Day92;

import java.io.*;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while (!(line = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();

            boolean isBalancedStr = true;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) {
                        isBalancedStr = false;
                        break;
                    }

                    char prev = stack.pop();

                    if (!(prev == '(' && ch == ')') && !(prev == '[' && ch == ']')) {
                        isBalancedStr = false;
                        break;
                    }
                }
            }

            if (isBalancedStr && stack.isEmpty())
                bw.write("yes\n");
            else
                bw.write("no\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
