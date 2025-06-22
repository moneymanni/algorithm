package StepByStep.unionfind;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ20040 {

    private static int n, m;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        boolean check = false;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (same(a, b)) {
                bw.write((i + 1) + "\n");
                check = true;
                break;
            } else {
                union(a, b);
            }
        }

        if (!check) {
            bw.write(0 + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean same(int a, int b) {
        return find(a) == find(b);
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
}
