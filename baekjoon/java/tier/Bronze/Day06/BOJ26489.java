package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ26489 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String strLine = "";

            int cnt = 0;
            while ((strLine = br.readLine()) != null) {
                cnt++;
            }
            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Scanner scan = new Scanner(System.in);
//
//        int cnt = 0;
//        while (scan.hasNext()) {
//            String strLine = scan.nextLine();
//            cnt++;
//        }
//        System.out.println(cnt);
    }
}
