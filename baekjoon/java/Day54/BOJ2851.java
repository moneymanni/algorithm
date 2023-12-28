package Day54;

import java.io.*;

public class BOJ2851 {
    public static final int TARGET_SCORE = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++)
            scores[i] = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (Math.abs(sum - TARGET_SCORE) < Math.abs((sum + scores[i]) - TARGET_SCORE))
                break;

            sum += scores[i];

            if (sum >= TARGET_SCORE)
                break;
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
