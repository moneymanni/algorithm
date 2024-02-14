package Silver5.Day75;

import java.io.*;

public class BOJ1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String doc = br.readLine();
        String search = br.readLine();

        // 슬라이딩 윈도우
        int k = search.length();
        int cnt = 0;
        for (int i = 0; i <= doc.length() - k; i++) {
            String word = doc.substring(i, i + k);

            if (word.equals(search)) {
                cnt++;
                i += k - 1;
            }
        }
        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
