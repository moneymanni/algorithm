package Day6;

import java.util.Scanner;

public class BOJ30214 {
    public static void main(String[] args) {

        // 전반부에 참가자 중 최소 절반 이상이 문제를 해결해야 쉬운 문제
        // 모든 참가자는 Travis의 문제를 풀었다.
        Scanner scan = new Scanner(System.in);

        int S1 = scan.nextInt();  // 대회 전반전 종료 시 해결 인원
        int S2 = scan.nextInt();  // 대회 종료 시 해결 인원 (대회 총원)

        int halfPeople = S2 % 2 == 0 ? S2/2 : S2/2 + 1;
        System.out.println(halfPeople <= S1 ? "E" : "H");
//        System.out.println(S1*2 >= S2 ? "E" : "H");
    }
}
