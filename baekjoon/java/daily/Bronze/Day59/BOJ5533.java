package Day59;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] card = new int[N][3];
        for (int i = 0; i < card.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < card[i].length; j++)
                card[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                boolean isUnique = true;
                for (int k = 0; k < N; k++) {
                    if (i != k && card[i][j] == card[k][j]) {
                        card[k][j] = 0;
                        isUnique = false;
                    }
                }
                if (!isUnique)
                    card[i][j] = 0;
            }
            score[i] = card[i][0] + card[i][1] + card[i][2];
        }

        for (int num : score)
            bw.write(num + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
