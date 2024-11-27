package Silver4.Day104;

import java.io.*;

public class BOJ2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 이분 탐색
        long n = Long.parseLong(br.readLine());

        bw.write(String.valueOf(binarySearch(n)));


//        long n = Long.parseLong(br.readLine());
//        long q = (long) Math.sqrt(n);
//
//        if (q * q < n)
//            q++;
//
//        bw.write(q + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static long binarySearch(long n) {
        long result = 0;

        long start = 0;
        long end = n;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (n <= Math.pow(mid, 2)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}
