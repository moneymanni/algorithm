package Gold5.Day171;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cnt = findMinOperationsForTeleportDevice(x, y);

            bw.write(String.format("%d\n", cnt));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findMinOperationsForTeleportDevice(int start, int end) {
        int dist = end - start;
        int max = (int) Math.sqrt(dist);

        if (max == Math.sqrt(dist))
            return max * 2 - 1;
        else if (dist <= max * max + max)
            return max * 2;
        else
            return max * 2 + 1;
    }
}
