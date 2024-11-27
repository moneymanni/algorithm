package Silver4.Day103;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1755 {
    public static final String[] ONES = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[][] nums = new String[N-M+1][2];
        for (int i = M; i <= N; i++) {
            String eng = "";
            if (i < 10)
                eng = ONES[i];
            else
                eng = ONES[i/10] + " " + ONES[i%10];
            nums[i-M][0] = eng;
            nums[i-M][1] = String.valueOf(i);
        }

        Arrays.sort(nums, Comparator.comparing(a -> a[0]));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i % 10 == 0)
                sb.append('\n');
            sb.append(nums[i][1]);
            if (i % 10 != 9 && i < nums.length - 1)
                sb.append(' ');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
