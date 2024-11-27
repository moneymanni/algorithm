package Day46;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Long.parseLong(st.nextToken());

        long min;
        switch (n) {
            case 2:
                min = Math.min(num[0], num[1]);
                for (int i = 1; i <= min; i++) {
                    if (num[0] % i == 0 && num[1] % i == 0)
                        bw.write(i + "\n");
                }
                break;

            case 3:
                min = Math.min(num[0], Math.min(num[1], num[2]));
                for (int i = 1; i <= min; i++) {
                    if (num[0] % i == 0 && num[1] % i == 0 && num[2] % i == 0)
                        bw.write(i + "\n");
                }
                break;
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
