package Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];
        for (int i = 0; i < T; i++)
            testCase[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String binaryString = Integer.toBinaryString(testCase[i]);
            char[] binary = binaryString.toCharArray();

            for (int j = binary.length - 1; j >= 0; j--)
                if (binary[j] == '1')
                    System.out.printf("%d ", binary.length - j - 1);
            System.out.println();
        }

        br.close();
    }
}
