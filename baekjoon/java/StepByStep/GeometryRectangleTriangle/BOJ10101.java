package StepByStep.GeometryRectangleTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String result = "";

        if (a + b + c == 180) {
            if (a == b && b == c) {
                result = "Equilateral";
            } else if (a == b || b == c || a == c) {
                result = "Isosceles";
            } else {
                result = "Scalene";
            }
        } else {
            result = "Error";
        }

        System.out.println(result);

        br.close();
    }
}
