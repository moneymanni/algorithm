package Silver5.Day86;

import java.io.*;

public class BOJ11536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] players = new String[N];
        for (int i = 0; i < N; i++)
            players[i] = br.readLine();

        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 1; i < N; i++) {
            if (players[i-1].compareTo(players[i]) <= 0) {
                isDecreasing = false;
            } else if (players[i-1].compareTo(players[i]) >= 0) {
                isIncreasing = false;
            }

            if (!isIncreasing && !isDecreasing)
                break;
        }

        if (isIncreasing)
            bw.write("INCREASING");
        else if (isDecreasing)
            bw.write("DECREASING");
        else
            bw.write("NEITHER");

        br.close();
        bw.flush();
        bw.close();
    }
}
