package Day55;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int max = Integer.MIN_VALUE;
            String maxSchool = "";
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String S = st.nextToken();
                int L = Integer.parseInt(st.nextToken());

                if (L > max) {
                    max = L;
                    maxSchool = S;
                }
            }
            bw.write(maxSchool + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
