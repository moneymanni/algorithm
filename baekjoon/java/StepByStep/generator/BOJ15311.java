package StepByStep.generator;

import java.io.*;

public class BOJ15311 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();

        StringBuilder sb = new StringBuilder();

        sb.append("2000").append('\n');

        for (int i = 0; i < 1000; i++) {
            sb.append('1').append(' ');
        }

        for (int i = 0; i < 1000; i++) {
            sb.append("1000").append(' ');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
