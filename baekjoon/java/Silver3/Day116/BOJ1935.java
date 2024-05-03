package Silver3.Day116;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String postfixNotation = br.readLine();
        int[] arr = new int[N];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < postfixNotation.length(); i++) {
            char ch = postfixNotation.charAt(i);

            if (('A' <= ch && ch <= 'Z') && !map.containsKey(ch)) {
                map.put(ch, Integer.parseInt(br.readLine()));
            }
        }

        Stack<Double> stack = new Stack<>();
        int idx = 0;

        for (int i = 0; i < postfixNotation.length(); i++) {
            char ch = postfixNotation.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                stack.push(Double.valueOf(map.get(ch)));
            } else {
                double num = 0;
                double B = stack.pop();
                double A = stack.pop();

                switch (ch) {
                    case '+':
                        num = A + B;
                        break;
                    case '-':
                        num = A - B;
                        break;
                    case '*':
                        num = A * B;
                        break;
                    case '/':
                        num = A / B;
                        break;
                }

                stack.push(num);
            }
        }
        bw.write(String.format("%.2f", stack.pop()));

        br.close();
        bw.flush();
        bw.close();
    }
}
