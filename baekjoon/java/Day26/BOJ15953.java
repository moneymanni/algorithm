package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15953 {
    public static final int[] PRIZE_MONEY_1ST = {5_000_000, 3_000_000, 2_000_000, 500_000, 300_000, 100_000};
    public static final int[] PRIZE_MONEY_2ND = {5_120_000, 2_560_000, 1_280_000, 640_000, 320_000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][2];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            testCase[i][0] = Integer.parseInt(st.nextToken());
            testCase[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1회 : 6등을 1, 2, 3, 4, 5, 6명으로 나눔(총 21명)
        // 2회 : 5등을 1, 2, 4, 8, 16명으로 나눔(총 31명)
        for (int i = 0; i < T; i++) {
            int f_1st = testCase[i][0];
            int f_2nd = testCase[i][1];

            int total = 0;
            // 1, 3, 6, 10, 15, 21
//            if (f_1st == 1)
//                total += PRIZE_MONEY_1ST[0];
//            else if (1 < f_1st && f_1st <= 3)
//                total += PRIZE_MONEY_1ST[1];
//            else if (3 < f_1st && f_1st <= 6)
//                total += PRIZE_MONEY_1ST[2];
//            else if (6 < f_1st && f_1st <= 10)
//                total += PRIZE_MONEY_1ST[3];
//            else if (10 < f_1st && f_1st <= 15)
//                total += PRIZE_MONEY_1ST[4];
//            else if (15 < f_1st && f_1st <= 21)
//                total += PRIZE_MONEY_1ST[5];

            // 1, 3, 7, 15, 31
//            if (f_2nd == 1)
//                total += PRIZE_MONEY_2ND[0];
//            else if (1 < f_2nd && f_2nd <= 3)
//                total += PRIZE_MONEY_2ND[1];
//            else if (3 < f_2nd && f_2nd <= 7)
//                total += PRIZE_MONEY_2ND[2];
//            else if (7 < f_2nd && f_2nd <= 15)
//                total += PRIZE_MONEY_2ND[3];
//            else if (15 < f_2nd && f_2nd <= 31)
//                total += PRIZE_MONEY_2ND[4];

            // 1, 3, 6, 10, 15, 21
            int cnt = 0;
            for (int j = 0; j < 6; j++) {
                cnt += j + 1;
                if (f_1st == 0 || f_1st > 21)
                    break;
                if (f_1st <= cnt) {
                    total += PRIZE_MONEY_1ST[j];
                    break;
                }
            }

            // 1, 3, 7, 15, 31
            cnt = 0;
            for (int j = 0; j < 5; j++) {
                cnt += (int) Math.pow(2, j);
                if (f_2nd == 0 || f_2nd > 31)
                    break;
                if (f_2nd <= cnt) {
                    total += PRIZE_MONEY_2ND[j];
                    break;
                }
            }

            System.out.println(total);
        }

        br.close();
    }
}
