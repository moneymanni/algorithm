package Day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long num = N;
        while (true) {
            if (num == 1) {
                System.out.println("1");
                break;
            } else if (num % 2 != 0) {
                System.out.println("0");
                break;
            } else {
                num /= 2;
            }
        }

        br.close();
    }
}
