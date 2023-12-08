package Day41;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] parkingTime = new int[3][2];
        for (int i = 0; i < parkingTime.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < parkingTime[i].length; j++)
                parkingTime[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] time = new int[101];

        for (int i = 0; i < parkingTime.length; i++) {
            int start = parkingTime[i][0];
            int end = parkingTime[i][1];

            for (int j = start; j < end; j++)
                time[j]++;
        }

        int result = 0;
        for (int i = 0; i < time.length; i++) {
            switch (time[i]) {
                case 1:
                    result += A;
                    break;
                case 2:
                    result += B * time[i];
                    break;
                case 3:
                    result += C * time[i];
                    break;
            }
        }

        bw.write(String.format("%d", result));

        br.close();
        bw.close();
    }
}
