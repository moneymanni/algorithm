package doIt.day220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1707 {

    private static boolean isEven;
    private static int[] check;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            String[] s = br.readLine().split(" ");

            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;

            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");

                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);

                A[start].add(end);
                A[end].add(start);
            }

            for (int i= 1; i <= V; i++) {
                if (isEven) {
                    DFS(i);
                } else {
                    break;
                }
            }

            check[1] = 0;

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int node) {
        visited[node] = true;

        for (int i : A[node]) {
            if (!visited[i]) {
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리하기
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            } else if (check[node] == check[i]) {
                // 이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
                isEven = false;
            }
        }
    }
}
