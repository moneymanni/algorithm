package Gold5.Day186;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ21758 {
    private static int N;
    private static long[] map;
    private static long[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new long[N + 1];
        prefixSum = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map[i] = Long.parseLong(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + map[i];
        }

        long maxHoney = collectHoney();

        bw.write(maxHoney + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long collectHoney() {
        long maxHoney = 0;
        long fix, move;

        // 벌 왼쪽, 벌통 오른쪽 고정
        fix = prefixSum[N] - prefixSum[1];
        move = fix;

        for (int i = 2; i < N; i++) {
            long sum = fix - map[i];
            move -= map[i];

            maxHoney = Math.max(maxHoney, sum + move);
        }

        // 벌통 왼쪽, 벌 오른쪽 고정
        fix = prefixSum[N - 1];
        move = fix;

        for (int i = N - 1; i >= 2; i--) {
            long sum = fix - map[i];
            move -= map[i];

            maxHoney = Math.max(maxHoney, sum + move);
        }

        // 벌 왼쪽, 오른쪽 고정
        for (int i = 2; i < N; i++) {
            long left = prefixSum[i] - prefixSum[1];
            long right = prefixSum[N - 1] - prefixSum[i - 1];

            maxHoney = Math.max(maxHoney, left + right);
        }

        return maxHoney;
    }
}
