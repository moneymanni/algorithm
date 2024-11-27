package Silver5.Day87;

import java.io.*;

public class BOJ14606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = simulatePizzaPlay(N);
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int simulatePizzaPlay (int N) {
        if (N <= 1)
            return 0;

        int funScore = 0;
        for (int i = 1; i < N; i++) {
            int score = i * (N - i);
            score += simulatePizzaPlay(i) + simulatePizzaPlay(N - i);
            funScore = Math.max(funScore, score);
        }

        return funScore;
    }
}
