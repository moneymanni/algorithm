package Silver3.Day121;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String a = st.nextToken();
        String b = st.nextToken();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (a.length() + b.length() > str.length()) {
                sb.append("NE").append('\n');
                continue;
            }

            String front = str.substring(0, a.length());
            String back = str.substring(str.length() - b.length());

            if (front.equals(a) && back.equals(b))
                sb.append("DA").append('\n');
            else
                sb.append("NE").append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
