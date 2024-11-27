package Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2338 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger A = new BigInteger(st.nextToken());

            st = new StringTokenizer(br.readLine());
            BigInteger B = new BigInteger(st.nextToken());

            System.out.printf("%d\n%d\n%d", A.add(B), A.subtract(B), A.multiply(B));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
