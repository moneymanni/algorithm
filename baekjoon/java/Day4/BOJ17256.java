package Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17256 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            int az = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            int cz = Integer.parseInt(st.nextToken());

            int bx = cx-az;
            int by = cy/ay;
            int bz = cz-ax;

            System.out.printf("%d %d %d\n", bx, by, bz);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
