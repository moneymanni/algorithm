package Day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ21612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int B = Integer.parseInt(br.readLine());

        int kPa = 5 * B - 400;
        int result;
        if (kPa - 100 > 0)
            result = -1;
        else if (kPa - 100 < 0)
            result = 1;
        else
            result = 0;
        System.out.printf("%d\n%d", kPa, result);

        br.close();
    }
}
