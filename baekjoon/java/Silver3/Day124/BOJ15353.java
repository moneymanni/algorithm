package Silver3.Day124;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ15353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        BigInteger sum = A.add(B);
        bw.write(sum.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
