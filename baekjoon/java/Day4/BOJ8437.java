package Day4;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ8437 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger girlsApple = new BigInteger(scan.nextLine());
        BigInteger moreKlaudia = new BigInteger(scan.nextLine());

        System.out.printf("%d\n%d", (girlsApple.add(moreKlaudia)).divide(BigInteger.valueOf(2)), (girlsApple.subtract(moreKlaudia)).divide(BigInteger.valueOf(2)));
    }
}
