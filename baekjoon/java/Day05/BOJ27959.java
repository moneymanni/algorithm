package Day5;

import java.util.Scanner;

public class BOJ27959 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        System.out.println(N*100 >= M ? "Yes" : "No");
    }
}
