package Day55;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1145 {
    public static final int N = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int value = 1, cnt = 0;
        while (true) {
            for (int i = 0; i < N; i++) {
                if (value % nums[i] == 0)
                    cnt++;
            }

            if (cnt >= 3) {
                bw.write(value + "");
                break;
            }
            cnt = 0;
            value++;
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
