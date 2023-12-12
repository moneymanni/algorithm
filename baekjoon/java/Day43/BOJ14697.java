package Day43;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int result = 0;
        boolean possible = false;
        for (int i = 0; i <= N / A; i++) {
            for (int j = 0; j <= N / B; j++) {
                for (int k = 0; k <= N / C; k++) {
                    if ((A * i) + (B * j) + (C * k) == N) {
                        result = 1;
                        possible = true;
                        break;
                    }
                }
                if (possible) break;
            }
            if (possible) break;
        }
        bw.write(String.format("%d", result));

        bw.flush();
        br.close();
        bw.close();
    }
}
