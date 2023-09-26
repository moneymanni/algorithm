package Day1;

import java.util.Scanner;

public class BOJ10872 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int result = 1;
        for (int i = N; i > 0; i--)
            result *= i;
        System.out.println(result);
//        System.out.println(getFactorial(N));
    }

    public static int getFactorial(int num) {
        if (num <= 1)
            return 1;
        return getFactorial(num-1) * num;
    }
}
