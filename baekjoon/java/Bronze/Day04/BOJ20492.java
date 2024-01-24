package Day4;

import java.util.Scanner;

public class BOJ20492 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int case1 = (N / 100) * 78;
        int case2 = ((((N / 100) * 20) / 100) * 78) + ((N / 100) * 80);

        System.out.printf("%d %d\n", case1, case2);
    }
}
