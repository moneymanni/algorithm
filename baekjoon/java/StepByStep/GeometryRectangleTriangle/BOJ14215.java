package StepByStep.GeometryRectangleTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14215 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] triangle = new int[]{a, b, c};
        int result = 0;

        Arrays.sort(triangle);

        if (triangle[0] + triangle[1] > triangle[2]) {
            result = Arrays.stream(triangle).sum();
        } else {
            result = (triangle[0] + triangle[1]) * 2 - 1;
        }

        System.out.println(result);

        br.close();
    }
}
