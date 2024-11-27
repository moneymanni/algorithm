package Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ19602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());

        int happinessScore = S + 2 * M + 3 * L;
        String result = happinessScore >= 10 ? "happy" : "sad";

        System.out.println(result);

        br.close();
    }
}
