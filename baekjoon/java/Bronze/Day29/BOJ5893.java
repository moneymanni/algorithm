package Day29;

import java.io.*;
import java.math.BigInteger;

public class BOJ5893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger N = new BigInteger(br.readLine(), 2);
        N = N.multiply(BigInteger.valueOf(17));
        bw.write(N.toString(2));

        br.close();
        bw.close();
    }
}