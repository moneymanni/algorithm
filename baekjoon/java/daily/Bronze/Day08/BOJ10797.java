package Day8;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().strip());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++)
            if (Integer.parseInt(st.nextToken()) == n)
                cnt++;
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
