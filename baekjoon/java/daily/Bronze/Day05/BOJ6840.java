package Day5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ6840 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] num = new int[3];
        for (int i = 0; i < 3; i++)
            num[i] = scan.nextInt();

        Arrays.sort(num);
        System.out.println(num[1]);
    }
}
