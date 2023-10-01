package Day6;

import java.util.Scanner;

public class BOJ28113 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int A = scan.nextInt();
        int B = scan.nextInt();

        if (A < B || B < N)
            System.out.println("Bus");
        else if (A == B)
            System.out.println("Anything");
        else
            System.out.println("Subway");
    }
}
