package Day1;

import java.util.Scanner;

public class BOJ3003 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] black = {1, 1, 2, 2, 2, 8};
        int[] white = new int[6];  // king queen rook bishop knight pawn

        for (int i = 0; i < 6; i++)
            white[i] = scan.nextInt();

        for (int i = 0; i < 6; i++) {
            if (black[i] != white[i]) {
                System.out.printf("%d ", black[i] - white[i]);
                continue;
            }
            System.out.printf("%d ", 0);
        }
    }
}
