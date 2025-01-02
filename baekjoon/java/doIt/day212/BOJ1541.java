package doIt.day212;

import java.io.*;

public class BOJ1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        String[] plus = input.split("-");

        int result = add(plus[0]);

        for (int i = 1; i < plus.length; i++) {
            result -= add(plus[i]);
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int add(String str) {
        String[] numStr = str.split("\\+");

        int sum = 0;

        for (String s : numStr) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
