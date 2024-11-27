package Day68;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lines[i][1]);
        }

        boolean[] isProjected = new boolean[max + 1];
        for (int i = 0; i < N; i++) {
            int start = lines[i][0];
            int end = lines[i][1];
            for (int j = start; j < end; j++)
                isProjected[j] = true;
        }

        int sum = 0;
        for (int i = 1; i < isProjected.length; i++) {
            if (isProjected[i])
                sum++;
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
