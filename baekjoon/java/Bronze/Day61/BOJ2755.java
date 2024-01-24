package Day61;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        double total = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String subjectName = st.nextToken();
            int credit = Integer.parseInt(st.nextToken());
            String grade = st.nextToken();

            double num = Credit.fromString(grade).getGradeValue() * credit;
            total += num;
            sum += credit;
        }

        total = total / sum;
        bw.write(String.format("%.2f", total));

        br.close();
        bw.flush();
        bw.close();
    }

    public enum Credit {
        A_PLUS("A+", 4.3), A0("A0", 4.0), A_MINUS("A-", 3.7),
        B_PLUS("B+", 3.3), B0("B0", 3.0), B_MINUS("B-", 2.7),
        C_PLUS("C+", 2.3), C0("C0", 2.0), C_MINUS("C-", 1.7),
        D_PLUS("D+", 1.3), D0("D0", 1.0), D_MINUS("D-", 0.7),
        F("F", 0.0);

        private final String gradeString;
        private final double gradeValue;
        Credit (String gradeString, double gradeValue) {
            this.gradeString = gradeString;
            this.gradeValue = gradeValue;
        }

        public double getGradeValue () {
            return gradeValue;
        }

        public static Credit fromString (String gradeString) {
            for (Credit c : Credit.values()) {
                if (c.gradeString.equals(gradeString))
                    return c;
            }
            throw new IllegalArgumentException("Invalid grade string: " + gradeString);
        }
    }
}
