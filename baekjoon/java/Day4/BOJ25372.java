package Day4;

import java.util.Scanner;

public class BOJ25372 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine().strip());

        for (int i = 0; i < N; i++) {
            String password = scan.nextLine();
            if (6 <= password.length() && password.length() <= 9)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
