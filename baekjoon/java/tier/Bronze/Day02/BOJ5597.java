package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ5597 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> students = new ArrayList<>();

        while (scan.hasNext()) {
            students.add(scan.nextInt());
        }

        for (int i = 1; i <= 30; i++) {
            if (!students.contains(i))
                System.out.println(i);
        }
    }
}
