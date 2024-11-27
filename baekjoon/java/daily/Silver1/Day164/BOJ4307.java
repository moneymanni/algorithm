package Silver1.Day164;

import java.io.*;
import java.util.*;

public class BOJ4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCaseNum = Integer.parseInt(br.readLine());

        while (testCaseNum-- > 0) {
            st = new StringTokenizer(br.readLine());
            int stickLen = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            boolean[] positions = new boolean[stickLen + 1];

            for (int i = 0; i < n; i++)
                positions[Integer.parseInt(br.readLine())] = true;

            int min = findFastestTime(stickLen, positions);
            int max = findLatestTime(stickLen, positions);

            bw.write(String.format("%d %d\n", min, max));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findFastestTime(int len, boolean[] positions) {
        int left = len / 2;
        int right = len / 2;

        while (left > 0) {
            if (positions[left]) break;
            left--;
        }

        while (right < len) {
            if (positions[right]) break;
            right++;
        }

        return Math.max(left, len - right);
    }

    private static int findLatestTime(int len, boolean[] positions) {
        int left = 0;
        int right = len;

        while (left < len) {
            if (positions[left]) break;
            left++;
        }

        while (right > 0) {
            if (positions[right]) break;
            right--;
        }

        return Math.max(len - left, right);
    }
}
