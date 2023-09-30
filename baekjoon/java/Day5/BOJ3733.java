package Day5;

import java.util.Scanner;

public class BOJ3733 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            long N = scan.nextLong();
            long S = scan.nextLong();

            System.out.println(S / (N + 1));
        }
    }
}
