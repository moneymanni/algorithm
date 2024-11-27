package Day35;

import java.io.*;
import java.math.BigInteger;

public class BOJ15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        String line = br.readLine();
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < L; i++)
            result = result.add(BigInteger.valueOf(line.charAt(i) - 'a' + 1).multiply(BigInteger.valueOf(31).pow(i)));
        result = result.remainder(BigInteger.valueOf(1234567891));
        bw.write(result.toString());

        br.close();
        bw.close();
    }
}
