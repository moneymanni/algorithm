package Day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ7595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++)
                    System.out.print("*");
                System.out.println();
            }

            n = Integer.parseInt(br.readLine());
        }

        br.close();
    }
}
