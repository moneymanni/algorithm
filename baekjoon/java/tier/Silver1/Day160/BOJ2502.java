package Silver1.Day160;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (D == 3) {
            bw.write(String.format("%d\n%d", 1, K - 1));
        } else {
            int x = 1, y = 1;

            for (int i = 4; i <= D; i++) {
                int temp = y;
                y = x + y;
                x = temp;
            }

            int size = K / y;

            for (int i = size - 1; i >= 0; i--) {
                if ((K - i * y) % x == 0) {
                    bw.write(String.format("%d\n%d", (K - i * y) / x, i));
                    break;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
