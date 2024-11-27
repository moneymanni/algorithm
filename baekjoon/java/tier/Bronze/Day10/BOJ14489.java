package Day10;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(br.readLine());

        long sum = A + B;
        bw.write(sum - (2 * C) < 0 ? sum + "" : sum - (2 * C) + "");

        bw.flush();
        bw.close();
    }
}
