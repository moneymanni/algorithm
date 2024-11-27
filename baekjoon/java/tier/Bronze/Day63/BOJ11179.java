package Day63;

import java.io.*;
import java.math.BigInteger;

public class BOJ11179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger N = new BigInteger(br.readLine());

        StringBuilder binary = new StringBuilder(N.toString(2));
        binary.reverse();
        BigInteger result = new BigInteger(binary.toString(), 2);

        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
