package Day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        // A: 5(300), B: 1(60), C: 10(10)
        int cntA = T/300;
        int cntB = (T%300)/60;
        int cntC = ((T%300)%60)/10;
        if (((T%300)%60)%10 == 0)
            System.out.printf("%d %d %d", cntA, cntB, cntC);
        else
            System.out.println(-1);

        br.close();
    }
}
