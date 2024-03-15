package Silver4.Day89;

import java.io.*;

public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(minBags(N) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int minBags (int N) {
        for (int five = N / 5; five >= 0; five--) {
            int remain = N - (five * 5);

            if (remain % 3 == 0) {
                int three = remain / 3;
                return five + three;
            }
        }

        return -1;
    }
}
