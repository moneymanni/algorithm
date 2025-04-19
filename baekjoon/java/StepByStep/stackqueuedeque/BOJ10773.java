package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.Stack;

public class BOJ10773 {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            int cash = Integer.parseInt(br.readLine());

            if (cash == 0) {
                stack.pop();
            } else {
                stack.push(cash);
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
