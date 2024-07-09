package Silver1.Day156;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 {
    private static int N, M;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static int max;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());

            A[pointA].add(pointB);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            hackComputer(i);
        }

        for (int i = 1; i <= N; i++)
            if (max < result[i]) max = result[i];

        for (int i = 1; i<= N; i++) {
            if (max == result[i])
                System.out.print(i + " ");
        }

        br.close();
    }

    private static void hackComputer(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove();

            for (int i : A[node]) {
                if (visited[i]) continue;

                result[i]++;
                visited[i] = true;
                queue.add(i);
            }
        }
    }
}
