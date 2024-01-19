package Day67;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ1816 {
    public static boolean[] ck = new boolean[1_000_001];
    public static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        makePrime();

        while (N-- > 0) {
            long num = Long.parseLong(br.readLine());
            if (isValid(num))
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void makePrime () {
        for (int i = 2; i <= 1_000_000; i++) {
            if (ck[i]) continue;
            for (long j = i * 2; j <= 1_000_000; j += i) {
                ck[(int) j] = true;
            }
        }
        for (int i = 2; i <= 1_000_000; i++)
            if (!ck[i]) prime.add(i);
    }

    public static boolean isValid (long num) {
        for (int p : prime)
            if (num % p == 0) return false;
        return true;
    }
}

//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BOJ1816 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        while (N-- > 0) {
//            long S = Long.parseLong(br.readLine());
//
//            List<Long> factors = primeFactors(S);
//
//            boolean isProperCode = true;
//            for (Long factor : factors) {
//                if (factor <= Math.pow(10, 6)) {
//                    isProperCode = false;
//                    break;
//                }
//            }
//
//            if (isProperCode)
//                bw.write("YES\n");
//            else
//                bw.write("NO\n");
//        }
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//
//    public static List<Long> primeFactors (long num) {
//        List<Long> factors = new ArrayList<>();
//
//        for (long i = 2; i <= Math.sqrt(num); i++) {
//            while (num % i == 0) {
//                factors.add(i);
//                num /= i;
//            }
//        }
//
//        if (num != 1)
//            factors.add(num);
//
//        return factors;
//    }
//}