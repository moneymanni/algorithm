package Day55;

import java.io.*;

public class BOJ10448 {
    public static int[] triNum = new int[45];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];
        for (int i = 0; i < T; i++)
            testCase[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i < triNum.length - 1; i++)
            triNum[i] = i * (i + 1) / 2;

        for (int i = 0; i < T; i++) {
            int num = testCase[i];

            if (eureka(num))
                bw.write("1\n");
            else
                bw.write("0\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean eureka (int N) {
        for(int a = 1; a < triNum.length - 1; a++){
            for(int b = 1; b < triNum.length - 1; b++){
                for(int c = 1; c < triNum.length - 1; c++){
                    if(triNum[a] + triNum[b] + triNum[c] == N)
                        return true;
                }
            }
        }
        return false;
    }
}
