package Silver1.Day159;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ9934 {
    private static int K, size;
    private static int[] inorder;
    private static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        size = (int) Math.pow(2, K) - 1;
        inorder = new int[size + 1];
        tree = new ArrayList[K + 1];

        for (int i = 0; i <= K; i++)
            tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++)
            inorder[i] = Integer.parseInt(st.nextToken());

        search(1, 1, size);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= K; i++) {
            for (int value : tree[i])
                sb.append(value).append(' ');
            sb.append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void search(int depth, int start, int end) {
        int mid = (start + end) / 2;

        tree[depth].add(inorder[mid]);

        if (depth == K) return;
        search(depth + 1, start, mid - 1);
        search(depth + 1, mid + 1, end);
    }
}
