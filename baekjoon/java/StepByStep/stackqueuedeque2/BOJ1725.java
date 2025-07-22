package StepByStep.stackqueuedeque2;

import java.io.*;
import java.util.Stack;

public class BOJ1725 {

    private static int N;
    private static int[] arr;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        stack.push(0);

        int result = 0;

        for (int i = 1; i <= N + 1; i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();

                if (arr[top] <= arr[i]) {
                    break;
                }

                stack.pop();

                result = Math.max(result, arr[top] * (i - stack.peek() - 1));
            }

            stack.push(i);
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}
