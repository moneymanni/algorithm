package Day3;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ15740 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());

            bw.write(String.valueOf(A.add(B)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
