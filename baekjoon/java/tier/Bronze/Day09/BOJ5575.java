package Day9;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] work = new int[3];
            for (int j = 0; j < work.length; j++)
                work[j] = Integer.parseInt(st.nextToken());

            int[] leave = new int[3];
            for (int j = 0; j < leave.length; j++)
                leave[j] = Integer.parseInt(st.nextToken());

            int startTime = work[0]*3600 + work[1]*60 + work[2];
            int endTime = leave[0]*3600 + leave[1]*60 + leave[2];
            int result = endTime - startTime;
            bw.write(result/3600 + " " + (result%3600)/60 + " " + result%60 + "\n");
        }

        bw.flush();
        bw.close();
    }
}
