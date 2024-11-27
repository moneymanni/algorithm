package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger(br.readLine());
        String operator = br.readLine();
        BigInteger B = new BigInteger(br.readLine());

        switch (operator) {
            case "+":
                System.out.println(A.add(B));
                break;
            case "*":
                System.out.println(A.multiply(B));
                break;
        }

        br.close();
    }
}
