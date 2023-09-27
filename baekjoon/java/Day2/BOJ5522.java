package Day2;

import java.util.Scanner;

public class BOJ5522 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int scoreSum = 0;
        for (int i = 0; i < 5; i++)
            scoreSum += scan.nextInt();
        System.out.println(scoreSum);
    }
}
