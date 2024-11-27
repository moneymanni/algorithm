package Silver5.Day72;

import java.io.*;

public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int[] cnt = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            cnt[num]++;
        }
        cnt[6] = (int) Math.ceil((cnt[6] + cnt[9]) / 2.0);
        cnt[9] = 0;

        int max = Integer.MIN_VALUE;
        for (int i : cnt)
            max = Math.max(max, i);

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
