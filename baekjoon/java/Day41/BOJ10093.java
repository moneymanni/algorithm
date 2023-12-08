package Day41;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long max = Math.max(A, B);
        long min = Math.min(A, B);

        if (max == min)
            bw.write(0 + "");
        else
            bw.write((max - min - 1) + "\n");

        for (long i = min + 1; i < max; i++)
            bw.write(i + " ");

        br.close();
        bw.close();
    }
}
