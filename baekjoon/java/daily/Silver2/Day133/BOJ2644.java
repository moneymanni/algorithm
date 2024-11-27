package Silver2.Day133;

import java.io.*;
import java.util.*;

public class BOJ2644 {
    static int N, X, Y, M;
    static List<Node>[] nodeList;
    static boolean[] visited;
    static int result = -1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        nodeList = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList[a].add(new Node(b));
            nodeList[b].add(new Node(a));
        }
        dfs(X, Y, 0);
        System.out.println(result);
    }

    static void dfs(int start, int end, int count) {
        if (start == end) {
            result = count;
        } else {
            for (int i = 0; i < nodeList[start].size(); i++) {
                Node next = nodeList[start].get(i);
                if (!visited[next.node]) {
                    visited[next.node] = true;
                    dfs(next.node, end, count + 1);
                }
            }
        }
    }
}

class Node {
    int node;

    public Node(int node) {
        this.node = node;
    }

}