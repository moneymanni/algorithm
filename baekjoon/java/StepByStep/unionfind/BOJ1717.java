package StepByStep.unionfind;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1717 {

    private static final String YES = "YES";
    private static final String NO = "NO";

    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (op) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    if (same(a, b)) {
                        bw.write(YES + "\n");
                    } else {
                        bw.write(NO + "\n");
                    }
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private static boolean same(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }
}
