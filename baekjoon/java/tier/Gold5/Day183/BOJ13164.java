package Gold5.Day183;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<>();
        int totalCost = 0;

        for (int i = 1; i < N; i++)
            list.add(arr[i] - arr[i - 1]);

        Collections.sort(list);

        for (int i = 0; i < N - K; i++)
            totalCost += list.get(i);

        bw.write(totalCost + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
