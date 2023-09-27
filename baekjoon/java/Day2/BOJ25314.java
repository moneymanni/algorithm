package Day2;

import java.util.Scanner;

public class BOJ25314 {
    public static final String BYTE4 = "long";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        for (int i = 1; i <= (N/4); i++) {
            System.out.printf("%s ", BYTE4);
        }
        System.out.println("int");
    }
}
