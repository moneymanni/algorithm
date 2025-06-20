package StepByStep.unionfind;

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

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int op = Integer.parseInt(st.nextToken());

                if (op == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        boolean check = true;

        for (int i = 1; i < M; i++) {
            if (!same(num, Integer.parseInt(st.nextToken()))) {
                check = false;
                break;
            }
        }

        bw.write(check ? "YES\n" : "NO\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    private static boolean same(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }
}
