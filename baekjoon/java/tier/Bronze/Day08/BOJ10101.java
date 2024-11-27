package Day8;

import java.io.*;
import java.util.Arrays;

public class BOJ10101 {
    public static final String ALL_60 = "Equilateral";
    public static final String SUM_180_AND_TWO_SAME = "Isosceles";
    public static final String SUM_180_AND_NOT_SAME = "Scalene";
    public static final String NOT_180 = "Error";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] triangle = new int[3];
        for (int i = 0; i < 3; i++)
            triangle[i] = Integer.parseInt(br.readLine().strip());

        if (triangle[0] == 60 && triangle[1] == 60 && triangle[2] == 60)
            bw.write(ALL_60);
        else if (Arrays.stream(triangle).sum() == 180 && (triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[2] == triangle[0]))
            bw.write(SUM_180_AND_TWO_SAME);
        else if (Arrays.stream(triangle).sum() == 180)
            bw.write(SUM_180_AND_NOT_SAME);
        else
            bw.write(NOT_180);
        bw.flush();
        bw.close();
    }
}
