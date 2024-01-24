package Day4;

import java.util.Scanner;

public class BOJ14581 {
    public static final String FAN = ":fan:";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        System.out.printf("%s%s%s\n%s:%s:%s\n%s%s%s", FAN, FAN, FAN, FAN, name, FAN, FAN, FAN, FAN);
    }
}
