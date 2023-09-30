package Day5;

import java.util.Scanner;

public class BOJ27889 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        School schoolName = School.valueOf(scan.nextLine().strip());
        System.out.println(schoolName.fullName());
    }
}

enum School {
    NLCS("North London Collegiate School"),
    BHA("Branksome Hall Asia"),
    KIS("Korea International School"),
    SJA("St. Johnsbury Academy");

    private final String fullName;
    School(String fullName) {
        this.fullName = fullName;
    }
    public String fullName() {
        return fullName;
    }
}