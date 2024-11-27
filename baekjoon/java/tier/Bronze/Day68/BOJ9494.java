package Day68;

import java.io.*;

public class BOJ9494 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String[] line = new String[n];
            for (int i = 0; i < n; i++)
                line[i] = br.readLine();

            int space = 0;
            for (int i = 0; i < n; i++) {
                String text = line[i];
                for (int j = space; j < text.length(); j++) {
                    if (text.charAt(j) == ' ')
                        break;
                    space++;
                }
            }

            bw.write((space + 1) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
