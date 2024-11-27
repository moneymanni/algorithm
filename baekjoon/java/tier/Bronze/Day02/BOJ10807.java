package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10807 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        int v = scan.nextInt();

        long result = Arrays.stream(A)
                .filter(a -> a == v)
                .count();

        System.out.println(result);
    }
}
