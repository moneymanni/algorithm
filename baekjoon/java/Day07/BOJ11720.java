package Day7;

import java.util.Scanner;

public class BOJ11720 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine().strip());
        String num = scan.nextLine().strip();

        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += num.charAt(i) - '0';
        System.out.println(sum);
    }
}
