package Silver4.Day104;

import java.io.*;
import java.util.*;

public class BOJ15970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.putIfAbsent(y, new ArrayList<>());
            map.get(y).add(x);
        }

        int sum = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> arr = entry.getValue();

            Collections.sort(arr);

            int distance = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (i == 0)
                    distance = arr.get(i+1) - arr.get(i);
                else if (i == arr.size() - 1)
                    distance = arr.get(i) - arr.get(i-1);
                else
                    distance = Math.min(arr.get(i) - arr.get(i-1), arr.get(i+1) - arr.get(i));
                sum += distance;
            }
        }
        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
