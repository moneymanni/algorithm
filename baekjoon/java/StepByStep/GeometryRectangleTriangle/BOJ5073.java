package StepByStep.GeometryRectangleTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input;

        while (!(input = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            System.out.println(classifyTriangle(a, b, c));
        }

        br.close();
    }

    private static String classifyTriangle(int a, int b, int c) {
        String str;

        int longLine = 0;
        int shortLine1 = 0;
        int shortLine2 = 0;

        if (a >= b && a >= c) {
            longLine = a;
            shortLine1 = b;
            shortLine2 = c;
        } else if (b >= a && b >= c) {
            longLine = b;
            shortLine1 = a;
            shortLine2 = c;
        } else {
            longLine = c;
            shortLine1 = a;
            shortLine2 = b;
        }

        if (longLine < shortLine1 + shortLine2) {
            if (a == b && b == c) {
                str = "Equilateral";
            } else if (a == b || b == c || a == c) {
                str = "Isosceles";
            } else {
                str = "Scalene";
            }
        } else {
            str = "Invalid";
        }

        return str;
    }
}
