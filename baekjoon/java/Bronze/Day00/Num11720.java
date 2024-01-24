import java.util.Scanner;

/**
 * 숫자의 합 : 백준 온라인 저지 11720번
 * https://www.acmicpc.net/problem/11720
 */

public class Num11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String sNum = sc.next(); // 입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
        char[] cNum = sNum.toCharArray();
        
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
        }

        System.out.println(sum);
    }
}
