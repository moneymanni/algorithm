package Day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double line = Double.parseDouble(br.readLine());
        while (line >= 0.0) {
            System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", line, (line * 0.167));

            line = Double.parseDouble(br.readLine());
        }

        br.close();
    }
}
