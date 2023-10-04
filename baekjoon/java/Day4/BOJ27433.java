package Day4;

import java.util.Scanner;

public class BOJ27433 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        long fact = 1;
        for (int i = N; i >= 2; i--)
            fact *= i;

        System.out.println(fact);
//        System.out.println(getFactorial(N));
    }

//    public static long getFactorial(int num) {
//        if (num <= 1) {
//            return 1;
//        }
//        return getFactorial(num-1)*num;
//    }
}
