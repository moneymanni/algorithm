package Day6;

import java.util.Scanner;

public class BOJ30224 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        if (String.valueOf(N).indexOf('7') == -1 && N%7 != 0)
            System.out.println(0);
        else if (String.valueOf(N).indexOf('7') == -1 && N%7 == 0)
            System.out.println(1);
        else if (String.valueOf(N).indexOf('7') != -1 && N%7 != 0)
            System.out.println(2);
        else
            System.out.println(3);
    }
}
