package Day6;

import java.util.Scanner;

public class BOJ27328 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int A = scan.nextInt();
        int B = scan.nextInt();

        int result;
        if (A < B) result = -1;
        else if (A > B) result = 1;
        else result = 0;

        System.out.println(result);
    }
}
