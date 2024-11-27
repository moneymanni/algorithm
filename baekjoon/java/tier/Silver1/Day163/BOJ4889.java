package Silver1.Day163;

import java.io.*;
import java.util.Stack;

public class BOJ4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        String input;

        while(!(input = br.readLine()).contains("-")) {
            int num = findNumOfOperationsForStableStr(input);
            sb.append(idx++).append(". ").append(num).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findNumOfOperationsForStableStr(String input) {
        Stack<Character> stack = new Stack<>();

        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '}') {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        cnt++;
                        stack.push('{');
                    }
                } else {
                    cnt++;
                    stack.push('{');
                }
            } else {
                stack.push(ch);
            }
        }

        return cnt + stack.size() / 2;
    }
}
