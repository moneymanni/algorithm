package Silver2.Day136;

import java.io.*;
import java.util.*;

public class BOJ18352 {
    private static int N, M, K, X;
    private static ArrayList<Integer>[] city;
    private static boolean[] visited;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        city = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            city[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            city[A].add(B);
        }

        BFS(X);

        if (list.isEmpty()) {
            bw.write("-1");
        } else {
            Collections.sort(list);

            for (int i : list)
                bw.write(i + "\n");
        }

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
            int currCity = info[0];
            int dist = info[1];


            if (dist == K) {
                list.add(currCity);
            } else if (dist < K) {
                for (int i : city[currCity]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(new int[]{i, dist + 1});
                    }
                }
            }
        }
    }
}
