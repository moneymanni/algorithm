package Day30;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int num : nums)
            if (isPrime(num))
                cnt++;
        bw.write(cnt + "");

        br.close();
        bw.close();
    }
    public static boolean isPrime (int num) {
        if (num == 1)
            return false;

        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && i != num)
                return false;
        }
        return true;
    }
}
