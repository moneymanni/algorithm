package Silver2.Day141;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1058 {
    private static int N;
    private static int cnt, maxCnt;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // 유명한 사람 = 각 사람의 2-친구
        // A가 B의 2-친구 : 두 사람이 친구 || (C가 존재 : A와 친구 && B와 친구)

        maxCnt = Integer.MIN_VALUE;
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();

            for (int j = 1; j <= N; j++) {
                char ch = line.charAt(j - 1);

                if (ch == 'Y' && !A[i].contains(j)) {
                    A[i].add(j);
                    A[j].add(i);
                }
            }
        }


        for (int i = 1; i <= N; i++) {
            cnt = 0;
            Arrays.fill(visited, false);

            BFS(i);

            maxCnt = Math.max(maxCnt, cnt);
        }

        bw.write(maxCnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int v) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{v, 0});
        visited[v] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int num = info[0];
            int degree = info[1];

            if (degree == 1 || degree == 2) {
                cnt++;
            }

            for (int i : A[num]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, degree + 1});
                }
            }
        }
    }
}
