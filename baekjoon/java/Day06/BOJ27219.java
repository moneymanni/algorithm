package Day6;

import java.util.Scanner;

public class BOJ27219 {
    public static final String ONE = "I";
    public static final String FIVE = "V";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n/5; i++)
            System.out.printf("%s", FIVE);
        for (int i = 0; i < n%5; i++)
            System.out.printf("%s", ONE);
    }
}
