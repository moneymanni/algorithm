package Day5;

import java.util.Scanner;

public class BOJ5341 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        while (N != 0) {
            int sum = 0;
            for (int i = N; i >= 1; i--)
                sum += i;
            System.out.println(sum);
            N = scan.nextInt();
        }
    }
}
