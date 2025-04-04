package StepByStep.Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String reverse = new StringBuilder(input).reverse().toString();

        System.out.println(input.equals(reverse) ? 1 : 0);

        br.close();
    }
}
