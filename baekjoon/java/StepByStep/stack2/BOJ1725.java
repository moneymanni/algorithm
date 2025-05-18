package StepByStep.stack2;

import java.io.*;
import java.util.Stack;

public class BOJ1725 {

    private static int N;
    private static int[] histogram;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        histogram = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            histogram[i] = Integer.parseInt(br.readLine());
        }

        stack.push(0);

        int result = 0;

        for (int i = 1; i <= N + 1; i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();

                if (histogram[top] <= histogram[i]) {
                    break;
                }

                stack.pop();

                result = Math.max(result, histogram[top] * (i - stack.peek() - 1));
            }

            stack.push(i);
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
