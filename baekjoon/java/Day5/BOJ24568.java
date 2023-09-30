package Day5;

import java.util.Scanner;

public class BOJ24568 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int R = scan.nextInt();
        int S = scan.nextInt();

        int result = R*8 + S*3 - 28;
        System.out.println(result);
    }
}
