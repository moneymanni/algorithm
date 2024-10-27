package Gold5.Day185;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14567 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(dynamicProgramming());

        bw.flush();
        bw.close();
    }

    private static String dynamicProgramming() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] parents = new ArrayList[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = new ArrayList<>();
            parents[i].add(0);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            parents[to].add(from);
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j : parents[i])
                dp[i] = Math.max(dp[i], dp[j] + 1);

            sb.append(dp[i]).append(' ');
        }

        return sb.toString().trim();
    }

    private static String topologicalSort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cnt = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            cnt[to]++;
        }

        br.close();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0)
                queue.offer(i);
        }

        int[] arr = new int[N + 1];
        int hak = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- != 0) {
                int curr = queue.poll();
                arr[curr] = hak;

                for (int child : list[curr]) {
                    if (--cnt[child] == 0)
                        queue.offer(child);
                }
            }

            hak++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++)
            sb.append(arr[i]).append(' ');

        return sb.toString().trim();
    }
}
