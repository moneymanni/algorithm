package Gold5.Day174;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {
    private static int N, delNum;
    private static int leafCnt;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        int root = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == -1) {
                root = i;
            } else {
                graph[i].add(num);
                graph[num].add(i);
            }
        }

        delNum = Integer.parseInt(br.readLine());

        if (delNum == root)
            leafCnt = 0;
        else
            DFS(root);

        bw.write(Integer.toString(leafCnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v) {
        visited[v] = true;

        int nodeCnt = 0;

        for (int currNode : graph[v]) {
            if (currNode != delNum && !visited[currNode]) {
                nodeCnt++;
                DFS(currNode);
            }
        }

        if (nodeCnt == 0)
            leafCnt++;
    }
}
