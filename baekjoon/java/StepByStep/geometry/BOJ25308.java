package StepByStep.geometry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ25308 {

    private static final int NUM = 8;

    private static int cnt;
    private static int[] a = new int[NUM];
    private static int[] seq = new int[NUM];
    private static boolean[] visited = new boolean[NUM];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NUM; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        seq[0] = a[0];
        visited[0] = true;

        backtracking(1);

        bw.write((cnt * NUM) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void backtracking(int depth) {
        if (depth == NUM) {
            if (isConvex(0) && isConvex(1)) {
                cnt++;
            }
            return;
        }

        for (int i = 1; i < NUM; i++) {
            if (visited[i]) continue;

            seq[depth] = a[i];

            if (depth < 2 || isConvex(depth)) {
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean isConvex(int curr) {
        int prev = (curr + NUM - 2) % NUM;
        int mid = (curr + NUM - 1) % NUM;
        int next = curr % NUM;

        double line = Math.sqrt(2) * seq[prev] * seq[next] / (seq[prev] + seq[next]);
        return seq[mid] > line;
    }

}
