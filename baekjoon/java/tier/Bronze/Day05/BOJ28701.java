package Day5;

import java.util.Scanner;

public class BOJ28701 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int sum = 0;
        int last = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
            last += (int) Math.pow(i, 3);
        }
        System.out.printf("%d\n%d\n%d\n", sum, (int) Math.pow(sum, 2), last);
    }
}
