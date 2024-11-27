package Day32;

import java.io.*;

public class BOJ2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int N = Integer.parseInt(line);

        for (int i = 1; i <= N; i++) {
            char[] nums = String.valueOf(i).toCharArray();
            int sum = i;
            for (char num : nums)
                sum += num - '0';

            if (sum == N) {
                bw.write(i + "");
                break;
            }
            if (i == N)
                bw.write("0");
        }

        br.close();
        bw.close();
    }
}
