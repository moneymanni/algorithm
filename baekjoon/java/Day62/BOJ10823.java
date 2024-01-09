package Day62;

import java.io.*;

public class BOJ10823 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        String[] nums = sb.toString().split(",");

        long sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += Long.parseLong(nums[i]);
        System.out.println(sum);

        br.close();
        bw.flush();
        bw.close();
    }
}
