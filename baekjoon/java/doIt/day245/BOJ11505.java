package doIt.day245;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11505 {

    private static final int MOD = 1_000_000_007;

    private static int N, M, K;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int len = N;

        while (len != 0) {
            len /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftIdx = treeSize / 2 - 1;

        tree = new long[treeSize + 1];

        Arrays.fill(tree, 1);

        for (int i = leftIdx + 1; i <= leftIdx + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(leftIdx + b, c);
            } else if (a == 2) {
                b += leftIdx;
                c += leftIdx;
                bw.write(getMul(b, (int) c) + "\n");
            } else {
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long getMul(int s, int e) {
        long partMul = 1;

        while (s <= e) {
            if (s % 2 == 1) {
                partMul = partMul * tree[s] % MOD;
                s++;
            }

            if (e % 2 == 0) {
                partMul = partMul * tree[e] % MOD;
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return partMul;
    }

    private static void changeVal(int idx, long val) {
        tree[idx] = val;

        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx * 2] % MOD * tree[idx * 2 + 1] % MOD;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % MOD;
            i--;
        }
    }
}
