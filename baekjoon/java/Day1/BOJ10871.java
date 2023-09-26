package Day1;

import java.util.Scanner;

public class BOJ10871 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int X = scan.nextInt();

        int[] A = new int[N+1];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if (A[i] < X)
                System.out.print(A[i] + " ");
        }
    }
}
