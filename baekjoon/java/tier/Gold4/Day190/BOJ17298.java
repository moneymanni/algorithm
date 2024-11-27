package Gold4.Day190;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {

    private static int N;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        bw.write(solve());

        br.close();
        bw.flush();
        bw.close();
    }

    private static String solve() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i])
                A[stack.pop()] = A[i];

            stack.push(i);
        }

        while (!stack.isEmpty())
            A[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++)
            sb.append(A[i]).append(' ');

        return sb.toString();
    }
}
