package Day51;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1924 {
    public static final String[] DAYS = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    public static final int[] MONTHES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int N = 0;
        for (int i = 0; i < x; i++)
            N += MONTHES[i];
        N += y - 1;

        bw.write(DAYS[N % 7]);

        br.close();
        bw.flush();
        bw.close();
    }
}
