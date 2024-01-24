package Day27;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] A = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        char[] order = br.readLine().toCharArray();
        for (int i = 0; i < order.length; i++)
            bw.write(A[order[i] - 'A'] + " ");

        br.close();
        bw.close();
    }
}
