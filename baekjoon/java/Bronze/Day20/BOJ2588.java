package Day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        String num2String = String.valueOf(num2);
        for (int i = num2String.length() - 1; i >= 0; i--)
            System.out.println(num1 * Integer.parseInt(String.valueOf(num2String.charAt(i))));
        System.out.println(num1 * num2);

        br.close();
    }
}
