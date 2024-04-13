package Silver4.Day108;

import java.io.*;
import java.math.BigInteger;

public class BOJ13706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger N = new BigInteger(br.readLine());

        BigInteger result = N.sqrt();
        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
