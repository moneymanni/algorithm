package Silver3.Day122;

import java.io.*;

public class BOJ1788 {
    static long[] fibonacci;
    static final int MODULO = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n < 0)
            negativeFibonacci(n);
        else
            positiveFibonacci(n);

        long answer = fibonacci[fibonacci.length-1];

        StringBuilder sb = new StringBuilder();
        if (answer < 0)
            sb.append(-1).append('\n');
        else if (answer == 0)
            sb.append(0).append('\n');
        else
            sb.append(1).append('\n');
        sb.append(Math.abs(answer));

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void positiveFibonacci(int n) {
        fibonacci = new long[n + 1];

        if (n >= 0)
            fibonacci[0] = 0;
        if (n >= 1)
            fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++)
            fibonacci[i] = (fibonacci[i-2] + fibonacci[i-1]) % MODULO;
    }

    static void negativeFibonacci(int n) {
        int len = Math.abs(n);

        fibonacci = new long[len + 1];

        if (len >= 0)
            fibonacci[0] = 0;
        if (len >= 1)
            fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++)
            fibonacci[i] = (fibonacci[i-2] - fibonacci[i-1]) % MODULO;
    }
}
