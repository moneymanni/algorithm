package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] quadrant = {0, 0, 0, 0};
        int axis = 0;
        for (int i = 0; i < n; i++) {
            if (xy[i][0] > 0 && xy[i][1] > 0)
                quadrant[0]++;
            else if (xy[i][0] < 0 && xy[i][1] > 0)
                quadrant[1]++;
            else if (xy[i][0] < 0 && xy[i][1] < 0)
                quadrant[2]++;
            else if (xy[i][0] > 0 && xy[i][1] < 0)
                quadrant[3]++;
            else
                axis++;
        }
        System.out.printf("Q1: %d\nQ2: %d\nQ3: %d\nQ4: %d\nAXIS: %d", quadrant[0], quadrant[1], quadrant[2], quadrant[3], axis);

        br.close();
    }
}
