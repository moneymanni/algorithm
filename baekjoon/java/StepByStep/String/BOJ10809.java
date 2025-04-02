package StepByStep.String;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10809 {

    private static int[] alphabets = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Arrays.fill(alphabets, -1);

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'a';

            if (alphabets[num] != -1) continue;

            alphabets[num] = i;
        }

        for (int alphabet : alphabets) {
            System.out.print(alphabet + " ");
        }
    }
}
