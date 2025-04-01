package StepByStep.OneDimensionalArray;

import java.util.Scanner;

public class BOJ1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        double result = 100.0 * sum / max / N;

        System.out.println(result);
    }
}
