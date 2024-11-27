package Day4;

import java.util.Scanner;

public class BOJ21300 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        int beer = scan.nextInt();
//        int malt = scan.nextInt();
//        int wineProducts = scan.nextInt();
//        int carbonatedSoftDrinks = scan.nextInt();
//        int seltzer = scan.nextInt();
//        int water = scan.nextInt();
//        int result = 5 * (beer + malt + wineProducts + carbonatedSoftDrinks + seltzer + water);

        int result = 0;
        for (int i = 0; i < 6; i++)
            result += 5 * scan.nextInt();

        System.out.println(result);
    }
}
