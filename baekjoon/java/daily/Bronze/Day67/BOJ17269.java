package Day67;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int min = Math.min(N, M);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++)
            sb.append(A.charAt(i)).append(B.charAt(i));
        if (N != M) {
            sb.append(min == N ? B.substring(min) : A.substring(min));
        }

        StringBuilder nums = new StringBuilder();
        for (int i = 0; i < sb.length(); i++)
            nums.append(Alphabets.getStrokeNumOfChar(sb.charAt(i)));

        sb.setLength(0);
        while (true) {
            for (int i = 0; i < nums.length() - 1; i++) {
                String num = String.valueOf((nums.charAt(i) - '0') + (nums.charAt(i + 1) - '0'));
                sb.append(num.length() < 2 ? num : num.charAt(num.length() - 1));
            }
            nums = new StringBuilder(sb.toString());
            sb.setLength(0);

            if (nums.length() <= 2)
                break;
        }

        bw.write(Integer.parseInt(nums.toString()) + "%");

        br.close();
        bw.flush();
        bw.close();
    }

    public enum Alphabets {
        A(3), B(2), C(1),
        D(2), E(4), F(3),
        G(1), H(3), I(1),
        J(1), K(3), L(1),
        M(3), N(2), O(1),
        P(2), Q(2), R(2),
        S(1), T(2), U(1),
        V(1), W(1), X(2),
        Y(2), Z(1);

        private final int strokeNum;
        Alphabets (int strokeNum) {
            this.strokeNum = strokeNum;
        }

        public int getStrokeNum() {
            return strokeNum;
        }

        public static int getStrokeNumOfChar (char alphabet) {
            for (Alphabets alpha : Alphabets.values()) {
                if (alpha.name().charAt(0) == alphabet) {
                    return alpha.getStrokeNum();
                }
            }
            return -1;
        }
    }
}
