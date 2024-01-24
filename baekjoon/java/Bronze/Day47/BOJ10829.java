package Day47;

import java.io.*;
import java.math.BigInteger;

public class BOJ10829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger N = new BigInteger(br.readLine());
        bw.write(N.toString(2));

        bw.flush();
        br.close();
        bw.close();
    }
}
