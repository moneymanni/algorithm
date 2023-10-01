package Day6;

import java.util.Scanner;

public class BOJ27324 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String N = scan.nextLine().strip();

        int result = N.charAt(0) == N.charAt(1) ? 1 : 0;
        System.out.println(result);
    }
}
