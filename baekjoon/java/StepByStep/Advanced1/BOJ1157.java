package StepByStep.Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {

    private static int[] alphabets = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            alphabets[input.charAt(i) - 'A']++;
        }

        int maxVal = 0;
        int maxIdx = 0;
        boolean equals = false;

        for (int i = 0; i < alphabets.length; i++) {
            if (maxVal < alphabets[i]) {
                maxVal = alphabets[i];
                maxIdx = i;
                equals = false;
            } else if (maxVal == alphabets[i]) {
                equals = true;
            }
        }

        System.out.println(equals ? "?" : (char) ('A' + maxIdx));

        br.close();
    }
}
