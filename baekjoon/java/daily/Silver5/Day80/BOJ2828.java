package Silver5.Day80;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M;
        int sum = 0;
        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());

            if (apple < left) {
                sum += left - apple;
                right -= left - apple;
                left = apple;
            } else if (apple > right) {
                sum += apple - right;
                left += apple - right;
                right = apple;
            }
        }
        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
