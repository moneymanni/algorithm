package Day13;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < 5; i++)
            if (T == Integer.parseInt(st.nextToken()))
                cnt++;
        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}
