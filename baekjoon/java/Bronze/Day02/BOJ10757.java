package Day2;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ10757 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger A = scan.nextBigInteger();
        BigInteger B = scan.nextBigInteger();

        Integer C = scan.nextInt();

        System.out.println(A.add(B));
    }
}
