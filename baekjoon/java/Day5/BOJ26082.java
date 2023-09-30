package Day5;

import java.util.Scanner;

public class BOJ26082 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();

        System.out.println(((B / A) * 3) * C);
    }
}
