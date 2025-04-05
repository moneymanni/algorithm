package StepByStep.GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = (int) Math.pow(Math.sqrt(Math.pow(4, N)) + 1, 2);

        System.out.println(result);

        br.close();
    }
}
