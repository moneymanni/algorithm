package StepByStep.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'C') result += 3;
            else if (ch >= 'D' && ch <= 'F') result += 4;
            else if (ch >= 'G' && ch <= 'I') result += 5;
            else if (ch >= 'J' && ch <= 'L') result += 6;
            else if (ch >= 'M' && ch <= 'O') result += 7;
            else if (ch >= 'P' && ch <= 'S') result += 8;
            else if (ch >= 'T' && ch <= 'V') result += 9;
            else if (ch >= 'W' && ch <= 'Z') result += 10;
        }

        System.out.println(result);

        br.close();
    }
}
