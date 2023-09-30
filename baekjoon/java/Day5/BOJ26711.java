package Day5;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ26711 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger a = new BigInteger(scan.nextLine());
        BigInteger b = new BigInteger(scan.nextLine());

        System.out.println(a.add(b));
    }
}
