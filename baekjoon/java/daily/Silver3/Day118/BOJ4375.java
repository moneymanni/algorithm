package Silver3.Day118;

import java.io.*;
import java.math.BigInteger;

public class BOJ4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            BigInteger num = new BigInteger(line);
            BigInteger base = BigInteger.ZERO;

            while(true) {
                base = base.multiply(BigInteger.TEN).add(BigInteger.ONE);
                if (base.mod(num).equals(BigInteger.ZERO)) {
                    sb.append(base.toString().length()).append('\n');
                    break;
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
