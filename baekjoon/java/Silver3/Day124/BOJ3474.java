package Silver3.Day124;

import java.io.*;

public class BOJ3474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int two = 0, five = 0;
            for (int i = 2; i <= N; i *= 2)
                two += N / i;
            for (int i = 5; i <= N; i *= 5)
                five += N / i;

            bw.write(Math.min(two, five) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
