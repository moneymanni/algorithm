package StepByStep.stack2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17299 {

    private static final int MAX_NUM = 1_000_000;

    private static int N;
    private static int[] A, cnt, result;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        cnt = new int[MAX_NUM + 1];
        result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            cnt[A[i]]++;
        }

        for (int i =0; i < N; i++) {
            while (!stack.isEmpty() && cnt[A[i]] > cnt[A[stack.peek()]]) {
                result[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i : result) {
            bw.write(i + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
