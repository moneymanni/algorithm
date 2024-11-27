package doit.day195;

import java.io.*;

public class BOJ11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i) - '0';
            sum += arr[i];
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
