package Day50;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> primeFac = seekPrimeFactorization(N);

        for (Integer num : primeFac) {
            bw.write(num + "\n");
        }

//        for (int i = 2; i <= Math.sqrt(N); i++) {
//            while (N % i == 0) {
//                bw.write(i + "\n");
//                N /= i;
//            }
//        }
//        if (N != 1)
//            bw.write(N + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static List<Integer> seekPrimeFactorization (int N) {
        List<Integer> primeFac = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                primeFac.add(i);
                N /= i;
            }
        }

        if (N != 1)
            primeFac.add(N);

        return primeFac;
    }
}
