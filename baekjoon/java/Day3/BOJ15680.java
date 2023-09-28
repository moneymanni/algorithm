package Day3;

import java.util.Scanner;

public class BOJ15680 {
    public static final String UNIV_NAME = "YONSEI";
    public static final String UNIV_SLOGAN = "Leading the Way to the Future";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        String output = N == 0 ? UNIV_NAME : UNIV_SLOGAN;

        System.out.println(output);
    }
}
