package Day6;

import java.util.Scanner;

public class BOJ26766 {
    public static final String HEART = " @@@   @@@ \n" +
            "@   @ @   @\n" +
            "@    @    @\n" +
            "@         @\n" +
            " @       @ \n" +
            "  @     @  \n" +
            "   @   @   \n" +
            "    @ @    \n" +
            "     @     ";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        for (int i = 0; i < N; i++)
            System.out.println(HEART);
    }
}
