package Day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] vote = new int[N];
        for (int i = 0; i < N; i++)
            vote[i] = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int num : vote)
            sum += num;
        int majority = N / 2 + 1;
        if (majority <= sum)
            System.out.println("Junhee is cute!");
        else
            System.out.println("Junhee is not cute!");

        br.close();
    }
}
