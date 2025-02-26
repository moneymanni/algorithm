package doIt.day242;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1991 {

    private static int N;
    private static int[][] tree = new int[26][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }

            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();

        br.close();
        bw.flush();
        bw.close();
    }

    private static void preOrder(int curr) {
        if (curr == -1) {
            return;
        }

        System.out.print((char) (curr + 'A'));
        preOrder(tree[curr][0]);
        preOrder(tree[curr][1]);
    }

    private static void inOrder(int curr) {
        if (curr == -1) {
            return;
        }
        inOrder(tree[curr][0]);
        System.out.print((char) (curr + 'A'));
        inOrder(tree[curr][1]);
    }

    private static void postOrder(int curr) {
        if (curr == -1) {
            return;
        }
        postOrder(tree[curr][0]);
        postOrder(tree[curr][1]);
        System.out.print((char) (curr + 'A'));
    }
}
