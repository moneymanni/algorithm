package Silver5.Day85;

import java.io.*;

public class BOJ2622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int matchsticks = Integer.parseInt(br.readLine());

        int tri = 0;
        for (int i = 1; i <= matchsticks / 3; i++) {
            for (int j = i; j <= (matchsticks - i) / 2; j++) {
                int k = matchsticks - i - j;
                if (i + j > k)
                    tri++;
            }
        }

        bw.write(tri+"");

        br.close();
        bw.flush();
        bw.close();
    }
}
