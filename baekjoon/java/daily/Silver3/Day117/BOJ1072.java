package Silver3.Day117;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        // 이분 탐색
        int Z = getWinningPercentage(X, Y);

        int result = -1;
        int left = 0, right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (getWinningPercentage(X + mid, Y + mid) != Z) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(result + "");

//        StringTokenizer st = new StringTokenizer(br.readLine());
//        long X = Integer.parseInt(st.nextToken());
//        long Y = Integer.parseInt(st.nextToken());
//
//        int Z = (int) (Y * 100 / X);
//        int result = -1;
//
//        if (Z < 99)
//            result = (int) Math.ceil((100.0 * Y - X * (Z + 1)) / (Z - 99.0));
//
//        bw.write(result + "");
//
//        br.close();
//        bw.flush();
//        bw.close();
    }

    private static int getWinningPercentage(int X, int Y) {
        return (int) (Y * 100.0 / X);
    }
}
