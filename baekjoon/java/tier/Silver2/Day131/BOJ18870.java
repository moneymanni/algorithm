package Silver2.Day131;

import java.io.*;
import java.util.*;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sorted);

        int rank = 0;
        for (int i : sorted) {
            if (!rankMap.containsKey(i))
                rankMap.put(i, rank++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : origin)
            sb.append(rankMap.get(i)).append(' ');

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}

//public class BOJ18870 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[N];
//        Map<Integer, Integer> map = new TreeMap<>();
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            map.putIfAbsent(num, num);
//            arr[i] = num;
//        }
//
//        int idx = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet())
//            map.put(entry.getKey(), idx++);
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++)
//            sb.append(map.get(arr[i])).append(' ');
//
//        bw.write(sb.toString().trim());
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}
