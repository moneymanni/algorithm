package Day29;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ1837 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger P = new BigInteger(st.nextToken());
        BigInteger K = new BigInteger(st.nextToken());

        BigInteger i = BigInteger.ONE;
        while (true) {
            if (i.compareTo(K) > 0 || i.compareTo(K) == 0) {
                bw.write("GOOD");
                break;
            }
            i = i.add(BigInteger.ONE);
            if (P.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(K) < 0) {
                bw.write("BAD " + i);
                break;
            }
        }

        br.close();
        bw.close();
    }
}
