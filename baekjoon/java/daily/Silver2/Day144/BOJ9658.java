package Silver2.Day144;

import java.io.*;

public class BOJ9658 {
    private static boolean[] winSK;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        playGame(N);

        bw.write(winSK[N] ? "SK" : "CY");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void playGame(int num) {
        winSK = new boolean[num + 1];

        if (num >= 1) winSK[1] = false;
        if (num >= 2) winSK[2] = true;
        if (num >= 3) winSK[3] = false;
        if (num >= 4) winSK[4] = true;

        for (int i = 5; i <= num; i++) {
            winSK[i] = false;
            if (!winSK[i - 1] || !winSK[i - 3] || !winSK[i - 4])
                winSK[i] = true;
        }
    }
}
