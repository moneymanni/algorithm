package Day6;

import java.util.Scanner;

public class BOJ26575 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            double d = scan.nextDouble();
            double f = scan.nextDouble();
            double p = scan.nextDouble();

            String str = String.format("%.2f", d*f*p);
            System.out.printf("$%s\n", str);
        }
    }
}
