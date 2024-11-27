package Silver2.Day138;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = N; i >= 1; i--)
            list.add(A[i], i);

        for (int i : list)
            bw.write(i + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
