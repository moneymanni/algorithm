package StepByStep.tree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2263 {

    private static int n;
    private static int[] inorder, inIdx, postorder;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        inorder = new int[n + 1];
        inIdx = new int[n + 1];
        postorder = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            inIdx[inorder[i]] = i;
        }

        recursion(1, n, 1, n);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void recursion(int inStart, int inEnd, int postStart, int postEnd) {
        if (inEnd < inStart || postEnd < postStart) {
            return;
        }

        int root = postorder[postEnd];
        int rootIdx = inIdx[root];

        sb.append(root).append(' ');

        int len = rootIdx - inStart;

        recursion(inStart, rootIdx - 1, postStart, postStart + len - 1);
        recursion(rootIdx + 1, inEnd, postStart + len, postEnd - 1);
    }
}
