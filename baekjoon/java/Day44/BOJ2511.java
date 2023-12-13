package Day44;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 10;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardA = new int[N];
        for (int i = 0; i < N; i++)
            cardA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cardB = new int[N];
        for (int i = 0; i < N; i++)
            cardB[i] = Integer.parseInt(st.nextToken());

        int scoreA = 0;
        int scoreB = 0;
        char lastWinner = 'D';
        for (int i = 0; i < N; i++) {
            if (cardA[i] > cardB[i]) {
                scoreA += 3;
                lastWinner = 'A';
            } else if (cardA[i] < cardB[i]) {
                scoreB += 3;
                lastWinner = 'B';
            } else {
                scoreA++;
                scoreB++;
            }
        }

        bw.write(String.format("%d %d\n", scoreA, scoreB));
        if (scoreA > scoreB) {
            bw.write("A");
        } else if (scoreA < scoreB) {
            bw.write("B");
        } else {
            bw.write(String.format("%c", lastWinner));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
