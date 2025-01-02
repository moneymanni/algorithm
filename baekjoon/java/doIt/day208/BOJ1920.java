package doIt.day208;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//
//        Set<Integer> set = new HashSet<>();
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        while (N-- > 0)
//            set.add(Integer.parseInt(st.nextToken()));
//
//        int M = Integer.parseInt(br.readLine());
//
//        st = new StringTokenizer(br.readLine());
//        while (M-- > 0) {
//            int num = Integer.parseInt(st.nextToken());
//
//            bw.write(set.contains(num) ? "1\n" : "0\n");
//        }
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }

    private static int N;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while (M-- > 0) {
            long num = Long.parseLong(st.nextToken());

            bw.write(isNumInArr(num) ? "1\n" : "0\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isNumInArr(long target) {
        int startIdx = 0, endIdx = arr.length - 1;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (arr[midIdx] > target) {
                endIdx = midIdx - 1;
            } else if (arr[midIdx] < target) {
                startIdx = midIdx + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
