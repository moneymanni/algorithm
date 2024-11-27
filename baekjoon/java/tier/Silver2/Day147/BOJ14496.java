package Silver2.Day147;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14496 {
    private static int N, M;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static int minCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        minCnt = -1;

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            A[num1].add(num2);
            A[num2].add(num1);
        }

        BFS(a, b);

        bw.write(minCnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int node = info[0];
            int cnt = info[1];

            if (node == end) {
                minCnt = cnt;
                break;
            }

            for (int num : A[node]) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(new int[]{num, cnt + 1});
                }
            }
        }
    }
}
