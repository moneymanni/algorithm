package Silver5.Day76;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] nations = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++)
                nations[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nations, (a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1];
            if (b[2] != a[2]) return b[2] - a[2];
            return b[3] - a[3];
        });

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && !(nations[i][1] == nations[i-1][1] && nations[i][2] == nations[i-1][2] && nations[i][3] == nations[i-1][3])) {
                rank = i + 1;
            }

            if (nations[i][0] == K) {
                bw.write(rank + "");
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
