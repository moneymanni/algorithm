package Silver2.Day139;

import java.io.*;
import java.util.*;

public class BOJ11060 {
    private static int N;
    private static int cnt = -1;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());

            for (int j = i + 1; j <= i + num && j <= N; j++)
                A[i].add(j);
        }

        for (int i = 1; i <= N; i++)
            A[i].sort(Collections.reverseOrder());

        BFS(1);

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int v) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{v, 0});
        visited[v] = true;

        while (!queue.isEmpty()) {
            int[] nodeInfo = queue.remove();
            int nodeIdx = nodeInfo[0];
            int nodeCnt = nodeInfo[1];

            if (nodeIdx == N) {
                cnt = nodeCnt;
                break;
            }

            for (int i : A[nodeIdx]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, nodeCnt + 1});
                }
            }
        }
    }
}

//public class BOJ11060 {
//    private static int N;
//    private static int[] A;
//    private static int[] dp;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        N = Integer.parseInt(br.readLine());
//
//        A = new int[N + 1];
//        dp = new int[N + 1];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 1; i <= N; i++)
//            A[i] = Integer.parseInt(st.nextToken());
//
//        Arrays.fill(dp, Integer.MAX_VALUE);
//
//        dynamic();
//
//        if (dp[N] == Integer.MAX_VALUE)
//            bw.write("-1");
//        else
//            bw.write(dp[N] + "");
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//
//    private static void dynamic() {
//        dp[0] = dp[1] = 0;
//
//        for (int i = 1; i <= N; i++) {
//            if (dp[i] >= Integer.MAX_VALUE) continue;
//
//            for (int j = 1; j <= A[i] && i + j <= N; j++)
//                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
//        }
//    }
//}
