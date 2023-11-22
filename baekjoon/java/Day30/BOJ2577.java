package Day30;

import java.io.*;

public class BOJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] cnt = new int[10];
        char[] nums = String.valueOf(A*B*C).toCharArray();
        for (char num : nums)
            cnt[num - '0']++;
        for (int i : cnt)
            bw.write(i + "\n");

        br.close();
        bw.close();
    }
}
