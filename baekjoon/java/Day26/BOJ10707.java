package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        // X사 : P x A
        // Y사 : B (P <= C)
        // Y사 : B + (P - C) * D (P > C)
        int companyX = P * A;
        int companyY = P <= C ? B : B + (P - C) * D;
        if (companyX >= companyY)
            System.out.println(companyY);
        else
            System.out.println(companyX);

        br.close();
    }
}
