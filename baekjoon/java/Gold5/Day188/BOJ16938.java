package Gold5.Day188;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16938 {

    private static int N, L, R, X;
    private static int cnt;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        DFS(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v, int sum, int depth, int min, int max) {
        if (depth >= 2) {
            if (sum >= L && sum <= R && max - min >= X)
                cnt++;
        }

        for (int i = v; i < N; i++)
            DFS(i + 1, sum + A[i], depth + 1, Math.min(min, A[i]), Math.max(max, A[i]));
    }
}
