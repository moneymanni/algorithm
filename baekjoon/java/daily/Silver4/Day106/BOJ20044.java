package Silver4.Day106;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] skills = new int[2*n];
        for (int i = 0; i < 2*n; i++)
            skills[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(skills);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            min = Math.min(min, skills[i] + skills[(n*2)-(i+1)]);

        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
