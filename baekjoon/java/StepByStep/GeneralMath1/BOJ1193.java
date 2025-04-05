package StepByStep.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int crossCnt = 1;
        int prevCntSum = 0;

        while (true) {
            if (X <= prevCntSum + crossCnt) {
                if (crossCnt % 2 == 1) {
                    System.out.println(crossCnt - (X - prevCntSum - 1) + "/" + (X - prevCntSum));
                    break;
                } else {
                    System.out.println((X - prevCntSum) + "/" + (crossCnt - (X - prevCntSum - 1)));
                    break;
                }
            } else {
                prevCntSum += crossCnt;
                crossCnt++;
            }
        }

        br.close();
    }
}
