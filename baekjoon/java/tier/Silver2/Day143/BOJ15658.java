package Silver2.Day143;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15658 {
    private static int N;
    private static int max;
    private static int min;
    private static int[] A;
    private static int[] formulas;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        A = new int[N];
        formulas = new int[4];
        arr = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            formulas[i] = Integer.parseInt(st.nextToken());

        DFS(0, A[0]);

        bw.write(max + "\n" + min);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, int result) {
        if (depth == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);

            return;
        }

        int nextValue = A[depth + 1];

        for (int i = 0; i < 4; i++) {
            if (formulas[i] > 0) {
                formulas[i]--;

                switch (i) {
                    case 0:
                        DFS(depth + 1, result + nextValue);
                        break;
                    case 1:
                        DFS(depth + 1, result - nextValue);
                        break;
                    case 2:
                        DFS(depth + 1, result * nextValue);
                        break;
                    case 3:
                        DFS(depth + 1, result / nextValue);
                        break;
                }

                formulas[i]++;
            }
        }
    }
}
