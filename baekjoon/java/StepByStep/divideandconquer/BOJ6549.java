package StepByStep.divideandconquer;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ6549 {

    private static int n;
    private static long[] histogram;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;

        while (!(input = br.readLine()).equals("0")) {
            st = new StringTokenizer(input);

            n = Integer.parseInt(st.nextToken());

            histogram = new long[n + 1];

            for (int i = 0; i < n; i++) {
                histogram[i] = Long.parseLong(st.nextToken());
            }
            histogram[n] = 0;

            stack = new Stack<>();
            long maxArea = 0;

            for (int i = 0; i <= n; i++) {
                while (!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) {
                    int height = (int) histogram[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                    maxArea = Math.max(maxArea, (long) height * width);
                }
                stack.push(i);
            }

            bw.write(maxArea + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
