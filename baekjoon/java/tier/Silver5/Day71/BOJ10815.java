package Silver5.Day71;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 이분 탐색
        int N = Integer.parseInt(br.readLine());
        int[] ownedCard = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            ownedCard[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ownedCard);

        int M = Integer.parseInt(br.readLine());
        int[] numCard = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            numCard[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            if (binarySearch(0, N-1, ownedCard, numCard[i]))
                bw.write("1 ");
            else
                bw.write("0 ");
        }


        // HashMap
//        HashMap<String, Integer> owned = new HashMap<>();
//
//        int N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        while (N-- > 0)
//            owned.put(st.nextToken(), 0);
//
//        int M = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        StringBuilder result = new StringBuilder();
//        while (M-- > 0) {
//            if (owned.get(st.nextToken()) != null) {
//                result.append(1).append(" ");
//            } else {
//                result.append(0).append(" ");
//            }
//        }
//        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean binarySearch (int start, int end, int[] arr, int num) {
        while (start <= end) {
            int midIndex = (start + end) / 2;
            int midValue = arr[midIndex];

            if (num < midValue)
                end = midIndex - 1;
            else if (num > midValue)
                start = midIndex + 1;
            else
                return true;
        }
        return false;
    }
}
