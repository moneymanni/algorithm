package StepByStep.graphandtraversal;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2606 {

    private static int numComputers, numPairs;
    private static int cnt;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        numComputers = Integer.parseInt(br.readLine());
        numPairs = Integer.parseInt(br.readLine());

        cnt = 0;
        visited = new boolean[numComputers + 1];
        graph = new ArrayList[numComputers + 1];

        for (int i = 0; i <= numComputers; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numPairs; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        DFS(1);

        bw.write(--cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v) {
        visited[v] = true;
        cnt++;

        for (int next : graph[v]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
