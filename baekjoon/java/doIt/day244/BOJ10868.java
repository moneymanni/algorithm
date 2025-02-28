package doIt.day244;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10868 {

    private static int N, M;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int len = N;

        while (len != 0) {
            len /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftIdx = treeSize / 2 - 1;

        tree = new long[treeSize + 1];

        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = leftIdx + 1; i <= leftIdx + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            s += leftIdx;
            e += leftIdx;

            bw.write(getMin(s, e) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long getMin(int s, int e) {
        long min = Long.MAX_VALUE;

        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, tree[s]);
                s++;
            }
            s /= 2;

            if (e % 2 == 0) {
                min = Math.min(min, tree[e]);
                e--;
            }
            e /= 2;
        }

        return min;
    }

    private static void setTree(int i) {
        while (i != 1) {
            if (tree[i / 2] > tree[i]) {
                tree[i / 2] = tree[i];
            }

            i--;
        }
    }
}
