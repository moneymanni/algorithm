package Silver5.Day83;

import java.io.*;

public class BOJ5555 {
    public static final int NUM_OF_ALPHABETS = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String search = br.readLine();
        int N = Integer.parseInt(br.readLine());

        String[] rings = new String[N];
        for (int i = 0; i < N; i++)
            rings[i] = br.readLine();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String word = rings[i].repeat(2);

            if (word.contains(search))
                cnt++;
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
