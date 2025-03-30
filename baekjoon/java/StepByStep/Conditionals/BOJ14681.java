package StepByStep.Conditionals;

import java.util.Scanner;

public class BOJ14681 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int quadrant = getQuadrant(x, y);

        System.out.println(quadrant);
    }

    private static int getQuadrant(int x, int y) {
        int quadrant = 0;

        if (x > 0 && y > 0) {
            quadrant = 1;
        } else if (x < 0 && y > 0) {
            quadrant = 2;
        } else if (x < 0 && y < 0) {
            quadrant = 3;
        } else if (x > 0 && y < 0) {
            quadrant = 4;
        }

        return quadrant;
    }
}
