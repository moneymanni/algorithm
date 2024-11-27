package Silver2.Day140;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int min;

        while (true) {
            min = N / L - ((L - 1) / 2);

            if (min < 0 || L > 100) {
                min = -1;
                break;
            }

            int sum = (min * 2 + L - 1) * L / 2;

            if (sum == N)
                break;

            L++;
        }

        if (min == -1)
            bw.write("-1");
        else
            for (int i = 0; i < L; i++)
                bw.write((min + i) + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
