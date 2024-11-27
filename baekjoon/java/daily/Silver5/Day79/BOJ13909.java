package Silver5.Day79;

import java.io.*;

public class BOJ13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());

        // 제곱수의 약수의 개수가 홀수이기 때문에(예시. 1의 약수는 1, 4의 약수는 1,2,4로 홀수 개)
        // 어떠한 창문이 마지막에 열려 있으려면 그 창문의 번호가 제곱수여야 한다.
        // 따라서, 1부터 N까지의 수에서 제곱수의 개수를 찾으면 그것이 마지막에 열려 있는 창문의 개수가 된다.
        // 1부터 N까지의 수 중 제곱수는 √N이 가장 크기 때문에 √N의 정수 부분을 구하는 것이 가장 쉬운 방법이다.
        long result = (long) Math.sqrt(N);
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
