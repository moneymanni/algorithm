package Day6;

import java.util.Scanner;

public class BOJ29163 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine().strip());
        int oddCnt = 0;  // 홀수
        int evenCnt = 0;  // 짝수
        for (int i = 0; i < n; i++) {
            if (scan.nextInt() % 2 == 0)
                evenCnt++;
            else
                oddCnt++;
        }
        System.out.println(evenCnt > oddCnt ? "Happy" : "Sad");
    }
}
