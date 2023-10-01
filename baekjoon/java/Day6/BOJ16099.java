package Day6;

import java.util.Scanner;

public class BOJ16099 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            long lt = scan.nextInt();
            long wt = scan.nextInt();
            long le = scan.nextInt();
            long we = scan.nextInt();

            if (lt * wt > le * we)
                System.out.println("TelecomParisTech");
            else if (lt * wt < le * we)
                System.out.println("Eurecom");
            else
                System.out.println("Tie");
        }
    }
}
