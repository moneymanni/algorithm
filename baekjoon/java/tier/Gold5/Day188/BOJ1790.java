package Gold5.Day188;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long result = 0L;
        long len = 1;
        long cnt = 9;

        while (k > cnt * len) {
            k -= (cnt * len);
            result += cnt;

            len++;
            cnt *= 10;
        }

        result = (result + 1) + (k - 1) / len;

        if (result > N) {
            bw.write("-1\n");
        } else {
            int idx = (int) ((k - 1) % len);
            bw.write(String.valueOf(result).charAt(idx) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
