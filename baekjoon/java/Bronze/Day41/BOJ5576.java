package Day41;

import java.io.*;
import java.util.Arrays;

public class BOJ5576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] uniW = new int[10];
        int[] uniK = new int[10];
        for (int i = 0; i < uniW.length; i++)
            uniW[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < uniK.length; i++)
            uniK[i] = Integer.parseInt(br.readLine());

        // 어떤 정렬 알고리즘을 사용해도 된다.
        Arrays.sort(uniW);
        Arrays.sort(uniK);

        int sumW = 0, sumK = 0;
        for (int i = uniK.length - 3; i < uniK.length; i++) {
            sumW += uniW[i];
            sumK += uniK[i];
        }
        bw.write(String.format("%d %d", sumW, sumK));

        br.close();
        bw.close();
    }
}
