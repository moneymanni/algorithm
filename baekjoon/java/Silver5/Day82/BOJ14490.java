package Silver5.Day82;

import java.io.*;

public class BOJ14490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(":");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        long gcd = gcd(n, m);

        StringBuilder result = new StringBuilder();
        result.append(n / gcd).append(":").append(m / gcd);

        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static long gcd (int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
}
