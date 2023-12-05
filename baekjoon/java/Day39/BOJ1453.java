package Day39;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numOfCustomers = new int[N];
        for (int i = 0; i < N; i++)
            numOfCustomers[i] = Integer.parseInt(st.nextToken());

        boolean[] isEmptySeat = new boolean[100];
        Arrays.fill(isEmptySeat, true);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int seat = numOfCustomers[i] - 1;

            if (isEmptySeat[seat])
                isEmptySeat[seat] = false;
            else
                cnt++;
        }

        bw.write(String.format("%d", cnt));

        br.close();
        bw.close();
    }
}
