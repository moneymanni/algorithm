package Silver1.Day165;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ17610 {
    private static int k;
    private static int[] g;
    private static TreeSet<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        g = new int[k];
        list = new TreeSet<>();
        int S = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            g[i] = Integer.parseInt(st.nextToken());
            S += g[i];
        }

        DFS(0, 0);

        int cnt = 0;

        for (int i = 1; i <= S; i++) {
            if (!list.contains(i)) {
                cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int num, int depth) {
        if (num > 0) list.add(num);

        if (depth == k)
            return;

        for (int i = depth; i < k; i++) {
            DFS(num + g[i], i + 1);
            DFS(num - g[i], i + 1);
        }
    }
}
