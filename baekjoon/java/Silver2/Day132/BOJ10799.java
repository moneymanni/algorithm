package Silver2.Day132;

import java.io.*;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        char prevCh = ' ';
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();

                if (prevCh == '(')
                    cnt += stack.size();
                else
                    cnt++;
            }

            prevCh = ch;
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
