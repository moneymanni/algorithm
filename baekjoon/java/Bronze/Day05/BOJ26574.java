package Day5;

import java.util.Scanner;

public class BOJ26574 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            System.out.printf("%d %d\n", num, num);
        }
    }
}
