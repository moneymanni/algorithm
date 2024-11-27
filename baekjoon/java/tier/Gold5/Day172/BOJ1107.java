package Gold5.Day172;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1107 {
    private static final int INIT_CHANNEL = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] btn = new boolean[10];

        Arrays.fill(btn, true);

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                btn[Integer.parseInt(st.nextToken())] = false;
        }

        int result = countPressedBtnToChangeChannel(N, btn);

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int countPressedBtnToChangeChannel(int targetChannel, boolean[] btn) {
        int cnt = Math.abs(targetChannel - INIT_CHANNEL);

        for (int i = 0; i < 1_000_000; i++) {
            String strNum = String.valueOf(i);
            boolean isBroken =  false;

            for (int j = 0; j < strNum.length(); j++) {
                if (!btn[strNum.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int min = Math.abs(targetChannel - i) + strNum.length();
                cnt = Math.min(cnt, min);
            }
        }

        return cnt;
    }
}
