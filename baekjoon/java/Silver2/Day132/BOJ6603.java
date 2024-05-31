package Silver2.Day132;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6603 {
    private static final int NUM = 6;

    private static int k;
    private static int[] A;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line;

        while (!(line = br.readLine()).equals("0")) {
            st = new StringTokenizer(line);

            k = Integer.parseInt(st.nextToken());

            A = new int[k];
            visited = new boolean[k];

            for (int i = 0; i < k; i++)
                A[i] = Integer.parseInt(st.nextToken());

            DFS(0, 0);

            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v, int depth) {
        if (depth == NUM) {
            for (int i = 0; i < k; i++) {
                if (visited[i])
                    sb.append(A[i]).append(' ');
            }
            sb.append('\n');
        }

        for (int i = v; i < k; i++) {
            visited[i] = true;
            DFS(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
