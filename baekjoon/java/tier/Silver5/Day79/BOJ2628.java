package Silver5.Day79;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int dottedLine = Integer.parseInt(br.readLine());

        boolean[] widthArr = new boolean[width];
        boolean[] heightArr = new boolean[height];

        while (dottedLine-- > 0) {
            st = new StringTokenizer(br.readLine());
            int binary = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            if (binary == 0)
                heightArr[idx] = true;
            else
                widthArr[idx] = true;
        }

        int maxWidth = findMaxArea(widthArr);
        int maxHeight = findMaxArea(heightArr);
        int result = maxWidth * maxHeight;

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findMaxArea (boolean[] arr) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                max = Math.max(max, temp);
                temp = 1;
            } else {
                temp++;
            }
        }
        max = Math.max(max, temp);

        return max;
    }
}
