package Day4;

import java.util.Scanner;

public class BOJ20254 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int Ur = scan.nextInt();
        int Tr = scan.nextInt();
        int Uo = scan.nextInt();
        int To = scan.nextInt();

        int result = 56*Ur + 24*Tr + 14*Uo + 6*To;
        System.out.println(result);
    }
}
