package StepByStep.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {

    private static final int BAG_3KG = 3;
    private static final int BAG_5KG = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(getBagCnt(N));

        br.close();
    }

    private static int getBagCnt(int totalKg) {
        for (int five = totalKg / BAG_5KG; five >= 0; five--) {
            int remain = totalKg - (five * BAG_5KG);

            if (remain % BAG_3KG == 0) {
                int three = remain / 3;

                return five + three;
            }
        }

        return -1;
    }
}
