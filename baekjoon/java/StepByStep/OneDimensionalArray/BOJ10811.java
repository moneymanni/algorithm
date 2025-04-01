package StepByStep.OneDimensionalArray;

import java.util.Scanner;

public class BOJ10811 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] basket = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        while (M-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            reverse(basket, i, j);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }
    }

    private static void reverse(int[] basket, int i, int j) {
        while (i <= j) {
            int temp = basket[i];
            basket[i] = basket[j];
            basket[j] = temp;
            i++;
            j--;
        }
    }
}
