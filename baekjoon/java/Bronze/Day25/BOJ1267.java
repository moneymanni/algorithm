package Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] callTime = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < callTime.length; i++)
            callTime[i] = Integer.parseInt(st.nextToken());

        int feeY = 0;
        int feeM = 0;
        for (int time : callTime) {
            feeY += 10 * (time / 30 + 1);
            feeM += 15 * (time / 60 + 1);
        }
        if (feeM < feeY)
            System.out.printf("M %d", feeM);
        else if (feeM > feeY)
            System.out.printf("Y %d", feeY);
        else
            System.out.printf("Y M %d", feeM);

        br.close();
    }
}
