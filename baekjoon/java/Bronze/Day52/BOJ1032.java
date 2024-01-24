package Day52;

import java.io.*;
import java.util.Arrays;

public class BOJ1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] file = new String[N];
        for (int i = 0; i < N; i++)
            file[i] = br.readLine();

        int len = Arrays.stream(file)
                .mapToInt(String::length)
                .min()
                .orElse(0);
        for (int i = 0; i < len; i++) {
            boolean isSame = true;

            char ch = file[0].charAt(i);
            for (int j = 0; j < N; j++) {
                if (ch != file[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame)
                bw.write(ch + "");
            else
                bw.write("?");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
