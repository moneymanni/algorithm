package doIt.day223;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1976 {

    private static int N, M;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];

        for (int i = 1; i <= N; i++)
            parents[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1)
                    union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());

        boolean check = true;
        int start = find(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (start != find(num)) {
                check = false;
                break;
            }
        }

        bw.write(check ? "YES" : "NO");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        }
    }
}
