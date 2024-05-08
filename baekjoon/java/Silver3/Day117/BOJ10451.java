package Silver3.Day117;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10451 {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N + 1];
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i <= N; i++)
                graph[i] = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                graph[i].add(arr[i]);
                graph[arr[i]].add(i);
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    cnt++;
                    DFS(i);
                }
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS (int v) {
        if (visited[v])
            return;

        visited[v] = true;
        for (int num : graph[v]) {
            if (!visited[num])
                DFS(num);
        }
    }
}
