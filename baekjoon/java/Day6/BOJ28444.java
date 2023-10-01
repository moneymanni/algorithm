package Day6;

import java.util.Scanner;

public class BOJ28444 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int H = scan.nextInt();
        int I = scan.nextInt();
        int A = scan.nextInt();
        int R = scan.nextInt();
        int C = scan.nextInt();

        System.out.println(H*I - A*R*C);
    }
}
