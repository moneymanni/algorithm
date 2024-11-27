package Day4;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ13277 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());

            String result = String.valueOf(A.multiply(B));
            bw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
