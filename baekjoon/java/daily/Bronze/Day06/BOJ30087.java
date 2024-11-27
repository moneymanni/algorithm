package Day6;

import java.util.Scanner;

public class BOJ30087 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < N; i++) {
            Seminar seminar = Seminar.valueOf(scan.nextLine());
            System.out.println(seminar.getClassRoom());;
        }
    }
}

enum Seminar {
    Algorithm("204"),
    DataAnalysis("207"),
    ArtificialIntelligence("302"),
    CyberSecurity("B101"),
    Network("303"),
    Startup("501"),
    TestStrategy("105");

    private final String classRoom;
    Seminar(String classRoom) {
        this.classRoom = classRoom;
    }
    public String getClassRoom() {
        return classRoom;
    }
}
