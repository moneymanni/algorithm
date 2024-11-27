package Day31;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());  // 고정 비용
        long B = Long.parseLong(st.nextToken());  // 노트북 1대당 비용(가변 비용)
        long C = Long.parseLong(st.nextToken());  // 노트북 가격

        if (C <= B) {
            bw.write("-1");
        } else {
            long bep = A / (C - B) + 1;
            bw.write(bep + "");
        }

        br.close();
        bw.close();
    }
}
