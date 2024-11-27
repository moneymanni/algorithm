package Day29;

import java.io.*;

public class BOJ17614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            char[] nums = String.valueOf(i).toCharArray();
            for (char num : nums)
                if (num == '3' || num == '6' || num == '9')
                    cnt++;
        }
        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}
