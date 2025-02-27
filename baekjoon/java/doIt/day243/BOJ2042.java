package doIt.day243;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2042 {

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
        int leftStartIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];

        for (int i = leftStartIndex + 1; i <= leftStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(leftStartIndex + s, e);
            } else if (a == 2) {
                s += leftStartIndex;
                e += leftStartIndex;
                bw.write(getSum(s, (int) e) + "\n");
            } else {
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void changeVal(int idx, long val) {
        long diff = val - tree[idx];

        while (idx > 0) {
            tree[idx] += diff;
            idx /= 2;
        }
    }

    private static long getSum(int s, int e) {
        long partSum = 0;

        while (s <= e) {
            if (s % 2 == 1) {
                partSum += tree[s++];
            }
            if (e % 2 == 0) {
                partSum += tree[e--];
            }

            s /= 2;
            e /= 2;
        }

        return partSum;
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
