package Day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = 100;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 == 0)
                continue;
            if (num < min)
                min = num;
            sum += num;
        }
        if (sum == 0)
            System.out.println(-1);
        else
            System.out.printf("%d\n%d", sum, min);

        br.close();
    }
}
