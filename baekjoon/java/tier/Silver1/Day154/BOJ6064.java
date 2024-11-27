package Silver1.Day154;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = getCainCalendar(M, N, x, y);

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getCainCalendar(int M, int N, int x, int y) {
        x--; y--;

        // x < M ? x' = x + 1 : x' = 1
        // y < N ? y' = y + 1 : y' = 1
        for (int i = x; i < (N * M); i += M) {
            if (i % N == y)
                return i + 1;
        }

        return -1;
    }
}
