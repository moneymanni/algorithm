package Day3;

import java.util.Scanner;

public class BOJ15727 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt();

        int result = L % 5 != 0 ? (L / 5) + 1 : L / 5;

        System.out.println(result);
    }
}
