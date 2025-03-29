package StepByStep.IOAndOperations.Day268;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ11382 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger A = new BigInteger(sc.next());
        BigInteger B = new BigInteger(sc.next());
        BigInteger C = new BigInteger(sc.next());

        BigInteger result = A.add(B).add(C);

        System.out.println(result);
    }
}
