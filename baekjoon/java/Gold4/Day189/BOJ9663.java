package Gold4.Day189;

import java.io.*;

public class BOJ9663 {
    private static final int[] DX = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] DY = {1, 1, 0, -1, -1, -1, 0, 1};

    private static int N;
    private static int cnt;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        DFS(0);

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (check(depth))
                DFS(depth + 1);
        }
    }

    private static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i] || Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }

        return true;
    }
}
