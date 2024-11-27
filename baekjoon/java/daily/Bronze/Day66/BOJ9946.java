package Day66;

import java.io.*;

public class BOJ9946 {
    public static final int NUM_OF_ALPHABETS = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;
        while (true) {
            String A = br.readLine();
            String B = br.readLine();

            if (A.equals("END") && B.equals("END"))
                break;

            int[] AAlphabets = new int[NUM_OF_ALPHABETS];
            int[] BAlphabets = new int[NUM_OF_ALPHABETS];
            for (int i = 0; i < A.length(); i++)
                AAlphabets[A.charAt(i) - 'a']++;
            for (int i = 0; i < B.length(); i++)
                BAlphabets[B.charAt(i) - 'a']++;

            boolean isSame = true;
            for (int i = 0; i < NUM_OF_ALPHABETS; i++) {
                if (AAlphabets[i] != BAlphabets[i]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame)
                bw.write(String.format("Case %d: same\n", idx++));
            else
                bw.write(String.format("Case %d: different\n", idx++));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
