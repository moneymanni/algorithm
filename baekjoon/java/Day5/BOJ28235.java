package Day5;

import java.util.Scanner;

public class BOJ28235 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String chant = scan.nextLine().strip();

        switch (chant) {
            case "SONGDO":
                System.out.println("HIGHSCHOOL");
                break;
            case "CODE":
                System.out.println("MASTER");
                break;
            case "2023":
                System.out.println("0611");
                break;
            case "ALGORITHM":
                System.out.println("CONTEST");
                break;
        }
    }
}