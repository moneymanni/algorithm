package Day42;

import java.io.*;

public class BOJ18406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[] nums = String.valueOf(N).toCharArray();

        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length / 2; i++)
            left += nums[i];
        for (int i = nums.length / 2; i < nums.length; i++)
            right += nums[i];

        if (left == right)
            bw.write("LUCKY");
        else
            bw.write("READY");

        br.close();
        bw.close();
    }
}
