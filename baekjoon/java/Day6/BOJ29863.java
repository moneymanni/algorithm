package Day6;

import java.util.Scanner;

public class BOJ29863 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = scan.nextInt();  // 20, 21, 22, 23, 0, 1, 2, 3
        int end = scan.nextInt();  // 5, 6, 7, 8, 9, 10

        // 0 이후로부터는 +24를 더해준다. 다음날로 넘어갔으므로...
        start = start <= 3 ? start+24 : start;
        end = end+24;

        System.out.println(end - start);
    }
}
