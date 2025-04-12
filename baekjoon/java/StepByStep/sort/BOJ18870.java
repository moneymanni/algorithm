package StepByStep.sort;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] copy = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = copy[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(copy);

        Map<Integer, Integer> rankMap = new HashMap<>();

        int rank = 0;

        for (int i : copy) {
            if (!rankMap.containsKey(i)) {
                rankMap.put(i, rank++);
            }
        }

        for (int i : origin) {
            bw.write(String.format("%d ", rankMap.get(i)));
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}
