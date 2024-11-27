package Silver2.Day130;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        while (min < max) {
            int mid = (min + max) / 2;

            long sum = 0;

            for (int tree : trees) {
                if (tree - mid > 0)
                    sum += tree - mid;
            }

            if (sum < M)
                max = mid;
            else
                min = mid + 1;
        }

        bw.write(min - 1 + "");



        br.close();
        bw.flush();
        bw.close();
    }
}
