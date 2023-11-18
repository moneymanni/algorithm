package Day6;

import java.util.Scanner;

public class BOJ26209 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] line = new int[8];
        for (int i = 0; i < line.length; i++)
            line[i] = scan.nextInt();

        char result = 'S';
        for (int num : line)
            if (num != 1 && num != 0) {
                result = 'F';
                break;
            }
        System.out.println(result);
    }
}
