package Day58;

import java.io.*;

public class BOJ9933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] file = new String[N];
        for (int i = 0; i < N; i++)
            file[i] = br.readLine();

        int len = 0;
        char mean = '0';
        boolean isFound = false;
        for (int i = 0; i < N; i++) {
            String str = file[i];
            String reverseStr = new StringBuilder(str).reverse().toString();

            if (str.equals(reverseStr)) {
                len = str.length();
                mean = str.charAt(str.length()/2);
                break;
            }

            for (int j = i + 1; j < N; j++) {
                if (file[j].equals(reverseStr)) {
                    len = str.length();
                    mean = str.charAt(str.length()/2);
                    isFound = true;
                    break;
                }
            }

            if (isFound)
                break;
        }

        bw.write(String.format("%d %c", len, mean));

        br.close();
        bw.flush();
        bw.close();
    }
}
