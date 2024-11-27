package Silver1.Day160;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2564 {
    private static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int lon = Integer.parseInt(st.nextToken());
        int lat  = Integer.parseInt(st.nextToken());

        int num = Integer.parseInt(br.readLine());

        map = new int[num];

        int cnt = 0;
        int loc = 0;

        for (int i = 0; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            int temp = 0;

            switch (dir) {
                case 1:
                    temp = dist;
                    break;
                case 2:
                    temp = 2 * lon + lat - dist;
                    break;
                case 3:
                    temp = 2 * lon + 2 * lat - dist;
                    break;
                case 4:
                    temp = lon + dist;
                    break;
            }

            if (i < num)
                map[i] = temp;
            else
                loc = temp;
        }

        for (int i = 0; i < num; i++) {
            int path1 = Math.abs(loc - map[i]);
            int path2 = 2 * lon + 2 * lat - path1;

            cnt += Math.min(path1, path2);
        }

        bw.write(String.valueOf(cnt));

        br.close();
        bw.flush();
        bw.close();
    }
}
