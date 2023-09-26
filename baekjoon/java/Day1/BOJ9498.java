package Day1;

import java.util.Scanner;

public class BOJ9498 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = scan.nextInt();

        if (score <= 100 && score >= 90)
            System.out.println('A');
        else if (score >= 80)
            System.out.println('B');
        else if (score >= 70)
            System.out.println('C');
        else if (score >= 60)
            System.out.println('D');
        else if (score >= 0)
            System.out.println('F');
        else
            System.out.println("out of range");
    }
}
