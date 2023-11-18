package Day2;

import java.util.Scanner;

public class BOJ2475 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] pin = new int[5];

        for (int i = 0; i < pin.length; i++)
            pin[i] = scan.nextInt();

        int verification = 0;
        for (int num : pin)
            verification += num*num;
        verification %= 10;

        System.out.println(verification);
    }
}
