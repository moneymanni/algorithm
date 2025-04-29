package StepByStep.dynamicprogramming1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ24416 {

//    private static int topDownCnt = 0;
//    private static int bottomUpCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

//        fibonacci_bottom_up(n);
//        fibonacci_top_down(n);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);

        for (int i = 2; i < 41; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }

        bw.write(String.format("%d %d\n", list.get(n - 4), n - 2));

        br.close();
        bw.flush();
        bw.close();
    }

//    private static int fibonacci_top_down(int num) {
//        if (num == 1 || num == 2) {
//            topDownCnt++;
//            return 1;
//        }
//        return fibonacci_top_down(num - 1) + fibonacci_top_down(num - 2);
//    }
//
//    private static int fibonacci_bottom_up(int num) {
//        int[] dp = new int[num + 1];
//
//        dp[1] = dp[2] = 1;
//
//        for (int i = 3; i <= num; i++) {
//            bottomUpCnt++;
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[num];
//    }
}
