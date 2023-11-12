package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] triangle = new int[3];
            for (int i = 0; i < triangle.length; i++)
                triangle[i] = Integer.parseInt(st.nextToken());

            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0)
                break;

            Arrays.sort(triangle);
            if (triangle[0] + triangle[1] <= triangle[2]) {
                System.out.println("Invalid");
                continue;
            }

            if (triangle[0] == triangle[1] && triangle[1] == triangle[2])
                System.out.println("Equilateral");
            else if (triangle[0] == triangle[1] || triangle[1] == triangle[2])
                System.out.println("Isosceles");
            else
                System.out.println("Scalene");
        }

        br.close();
    }
}
