package Silver5.Day73;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        double score = 0;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String rating = st.nextToken();

            score += calculateCredit(credit, rating);
            if (!rating.equals("P"))
                sum += credit;
        }
        if (sum == 0) {
            bw.write("0.000000");
        } else {
            score /= sum;
            bw.write(String.format("%.6f", score));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static double calculateCredit (double credit, String rating) {
        double score = 0;

        switch (rating) {
            case "A+":
                score += 4.5;
                break;
            case "A0":
                score += 4.0;
                break;
            case "B+":
                score += 3.5;
                break;
            case "B0":
                score += 3.0;
                break;
            case "C+":
                score += 2.5;
                break;
            case "C0":
                score += 2.0;
                break;
            case "D+":
                score += 1.5;
                break;
            case "D0":
                score += 1.0;
                break;
            case "F": case "P":
                score += 0.0;
                break;
        }

        return score * credit;
    }
}
