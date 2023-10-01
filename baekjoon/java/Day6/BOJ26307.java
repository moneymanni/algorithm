package Day6;

import java.util.Scanner;

public class BOJ26307 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int HH = scan.nextInt();
        int MM = scan.nextInt();

        int m = 0;
        if (HH >= 9)
            m = (HH - 9) * 60;
        else
            m = (HH + 3) * 60;

        System.out.println(m + MM);
    }
}
