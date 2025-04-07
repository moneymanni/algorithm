package StepByStep.GeometryRectangleTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9063 {

    private static final int MIN_VALUE = -100_000;
    private static final int MAX_VALUE = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int minX = MAX_VALUE, maxX = MIN_VALUE;
        int minY = MAX_VALUE, maxY = MIN_VALUE;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        int result = (maxX - minX) * (maxY - minY);

        System.out.println(result);

        br.close();
    }
}
