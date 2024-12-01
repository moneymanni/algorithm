package doit.day199;

import java.io.*;
import java.util.Stack;

public class BOJ1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num >= idx) {
                while (num >= idx) {
                    stack.push(idx++);
                    sb.append('+').append('\n');
                }
                stack.pop();
                sb.append('-').append('\n');
            } else {
                if (stack.pop() > num) {
                    bw.write("NO");
                    flag = false;
                    break;
                } else {
                    sb.append('-').append('\n');
                }
            }
        }

        if (flag)
            bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
