package Day37;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] room = new int[2][7];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            room[s][g]++;
        }

        int cnt = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 1; j < room[i].length; j++) {
                cnt += room[i][j] / K;
                if (room[i][j] % K != 0)
                    cnt++;
            }
        }
        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}
