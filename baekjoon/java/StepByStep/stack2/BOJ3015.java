package StepByStep.stack2;

import java.io.*;
import java.util.Stack;

public class BOJ3015 {

    private static int N;
    private static int[] waiting;
    private static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        waiting = new int[N];

        for (int i = 0; i < N; i++) {
            waiting[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < waiting[i]) {
                result += stack.pop()[1];
            }

            if (stack.isEmpty()) {
                stack.push(new int[]{waiting[i], 1});
            } else {
                if (stack.peek()[0] > waiting[i]) {
                    stack.push(new int[]{waiting[i], 1});
                    result++;
                } else {
                    result += stack.peek()[1]++;

                    if (stack.size() > 1) {
                        result++;
                    }
                }
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
