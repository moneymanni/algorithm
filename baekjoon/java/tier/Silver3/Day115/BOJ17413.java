package Silver3.Day115;

import java.io.*;
import java.util.Stack;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            switch (ch) {
                case ' ':
                    while (!stack.isEmpty())
                        result.append(stack.pop());
                    result.append(' ');
                    break;
                case '<':
                    while (!stack.isEmpty())
                        result.append(stack.pop());

                    result.append(ch);
                    while (true) {
                        ch = line.charAt(++i);
                        result.append(ch);

                        if (ch == '>')
                            break;
                    }
                    break;
                default:
                    stack.push(ch);
            }
        }
        while (!stack.isEmpty())
            result.append(stack.pop());

        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
