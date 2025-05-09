package StepByStep.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ10816 {

    private static int N, M;
    private static Map<Integer, Integer> map;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int num = Integer.parseInt(st.nextToken());

            bw.write(map.getOrDefault(num, 0) + " ");
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}
