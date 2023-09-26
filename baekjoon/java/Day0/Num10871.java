import java.util.Scanner;

/**
 * X보다 작은 수 : 백준 온라인 저지 10871번
 * https://www.acmicpc.net/problem/10871
 */

public class Num10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        for (int i = 0; i < N; i++) {
            if (arr[i] < X) {
                System.out.println(arr[i] + " ");
            }
        }
    }
}
