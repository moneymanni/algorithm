package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4999 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String jaehwan = st.nextToken();

            st = new StringTokenizer(br.readLine());
            String doctor = st.nextToken();

            String visitHospital = jaehwan.length() >= doctor.length() ? "go" : "no";

            System.out.print(visitHospital);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
