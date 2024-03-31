package Silver4.Day102;

import java.io.*;

public class BOJ13699 {
    public static long[] sequence = new long[36];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        recurrenceRelation();

        bw.write(sequence[n] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void recurrenceRelation() {
        sequence[0] = 1;

        for (int i = 1; i < sequence.length; i++) {
            long temp = 0;
            for (int j = 0; j < i; j++)
                temp += sequence[j] * sequence[i-1-j];
            sequence[i] = temp;
        }
    }
}
