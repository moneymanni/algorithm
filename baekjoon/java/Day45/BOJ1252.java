package Day45;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger(st.nextToken(), 2);
        BigInteger B = new BigInteger(st.nextToken(), 2);

        BigInteger sum = A.add(B);
        String result = sum.toString(2);
        bw.write(result);

        bw.flush();
        br.close();
        bw.close();
    }
}
