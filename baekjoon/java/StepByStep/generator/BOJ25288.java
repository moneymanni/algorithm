package StepByStep.generator;

import java.io.*;

public class BOJ25288 {

    private static int N;
    private static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        for(int i = 1; i <= N; i++) {
            bw.write(str);
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
