package Day54;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ24416 {
    public static int code1_count;
    public static int code2_count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

//        code1_count = code2_count = 0;
//        fib(n);
//        fibonacci(n);
//
//        bw.write(String.format("%d %d", code1_count, code2_count));

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);

        for (int i = 2; i < 41; i++)
            list.add(list.get(i - 1) + list.get(i - 2));

        bw.write(String.format("%d %d", list.get(n - 4), n - 2));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int fib (int num) {
        if (num == 1 || num == 2) {
            code1_count++;
            return 1;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }

    public static int fibonacci (int num) {
        int[] arr = new int[num + 1];
        arr[1] = arr[2] = 1;
        for (int i = 3; i <= num; i++) {
            code2_count++;
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[num];
    }
}
