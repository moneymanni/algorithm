package StepByStep.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2720 {

    private static final int QUARTER = 25;
    private static final int DIME = 10;
    private static final int NICKEL = 5;
    private static final int PENNY = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] change = calculateChange(N);

            for (int i = 0; i < change.length; i++) {
                System.out.print(change[i] + " ");
            }
            System.out.println();
        }

        br.close();
    }

    private static int[] calculateChange(int cent) {
        int[] change = new int[4];

        change[0] = cent / QUARTER;
        cent %= QUARTER;
        change[1] = cent / DIME;
        cent %= DIME;
        change[2] = cent / NICKEL;
        change[3] = cent % NICKEL;

        return change;
    }
}
