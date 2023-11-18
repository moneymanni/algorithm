package Day4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ8370 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N1 = Integer.parseInt(st.nextToken());
            int K1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());
            int K2 = Integer.parseInt(st.nextToken());

            String result = String.valueOf((N1 * K1) + (N2 * K2));

            bw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
