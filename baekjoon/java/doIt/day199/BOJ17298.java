package doit.day199;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();

        stack.push(arr[N - 1]);
        outputStack.push(-1);

        for (int i = N - 2; i >= 0; i--) {
            int num = arr[i];

            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                outputStack.push(stack.peek());
                stack.push(num);
            } else {
                outputStack.push(-1);
                stack.push(num);
            }
        }

        while (!outputStack.isEmpty()) {
            bw.write(outputStack.pop() + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
