package Gold5.Day174;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = a;
                maxDp[1] = minDp[1] = b;
                maxDp[2] = minDp[2] = c;
                continue;
            }

            int maxDp0 = maxDp[0], maxDp2 = maxDp[2];
            int minDp0 = minDp[0], minDp2 = minDp[2];

            maxDp[0] = Math.max(maxDp[0], maxDp[1]) + a;
            maxDp[2] = Math.max(maxDp[1], maxDp[2]) + c;
            maxDp[1] = Math.max(Math.max(maxDp0, maxDp[1]), maxDp2) + b;

            minDp[0] = Math.min(minDp[0], minDp[1]) + a;
            minDp[2] = Math.min(minDp[1], minDp[2]) + c;
            minDp[1] = Math.min(Math.min(minDp0, minDp[1]), minDp2) + b;
        }

        int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        bw.write(String.format("%d %d", max, min));

        br.close();
        bw.flush();
        bw.close();
    }
}
