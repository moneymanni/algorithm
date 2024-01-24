package Day48;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] locOfStores = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                locOfStores[j] = Integer.parseInt(st.nextToken());

            int max = locOfStores[0];
            int min = locOfStores[0];
            for (int j = 1; j < n; j++) {
                int loc = locOfStores[j];
                max = Math.max(max, loc);
                min = Math.min(min, loc);
            }
            int result = (max - min) * 2;

            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
