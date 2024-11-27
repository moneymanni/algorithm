package Day39;

import java.io.*;
import java.util.Arrays;

public class BOJ6359 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];
        for (int i = 0; i < T; i++)
            testCase[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int numOfRoom = testCase[i];

            boolean[] openRoom = new boolean[numOfRoom];

            Arrays.fill(openRoom, true);
            for (int j = 2; j <= numOfRoom; j++) {
                int increase = 2;
                for (int k = j; k <= numOfRoom; k = j * increase++)
                    openRoom[k - 1] = !openRoom[k - 1];
            }

            int cnt = 0;
            for (boolean b : openRoom)
                if (b) cnt++;

            bw.write(String.format("%d\n", cnt));
        }

        br.close();
        bw.close();
    }
}
