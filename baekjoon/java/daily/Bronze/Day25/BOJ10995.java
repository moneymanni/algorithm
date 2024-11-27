package Day25;

import java.io.*;

public class BOJ10995 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N; i++) {
            if (i % 2 != 0)
                bw.write(" ");
            for (int j = 0; j < N; j++) {
                bw.write("* ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
