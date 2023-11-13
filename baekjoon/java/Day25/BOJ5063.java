package Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ad = new int[N][3];
        for (int i = 0; i < ad.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < ad[i].length; j++)
                ad[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < ad.length; i++) {
            int adProfit = ad[i][1] - ad[i][2];
            if (adProfit > ad[i][0])
                System.out.println("advertise");
            else if (adProfit < ad[i][0])
                System.out.println("do not advertise");
            else
                System.out.println("does not matter");
        }

        br.close();
    }
}
