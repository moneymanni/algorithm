package Day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] square = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            square[i][0] = Integer.parseInt(st.nextToken());
            square[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.printf("%d %d", onlyNum(square[0][0], square[1][0], square[2][0]), onlyNum(square[0][1], square[1][1], square[2][1]));

        br.close();
    }
    static int onlyNum(int num1, int num2, int num3) {
        if (num1 == num2)
            return num3;
        else if (num2 == num3)
            return num1;
        else
            return num2;
    }
}
