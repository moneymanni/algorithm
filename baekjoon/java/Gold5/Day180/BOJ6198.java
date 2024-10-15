package Gold5.Day180;

import java.io.*;
import java.util.Stack;

public class BOJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] h = new int[N];

        for (int i = 0; i < N; i++)
            h[i] = Integer.parseInt(br.readLine());

        String result = String.valueOf(sumBenchmarkAbleBuildings(h));
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static long sumBenchmarkAbleBuildings(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int len = arr.length;
        long sum = 0;

        for (int i = 0; i < len; i++) {
            int height = arr[i];

            while (!stack.isEmpty()) {
                if (stack.peek() <= height)
                    stack.pop();
                else
                    break;
            }

            sum += stack.size();
            stack.push(height);
        }

        return sum;
    }
}
