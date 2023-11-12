package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        int[] books = new int[9];
        for (int i = 0; i < books.length; i++)
            books[i] = Integer.parseInt(br.readLine());

        int sum = Arrays.stream(books).sum();
        System.out.println(total - sum);

        br.close();
    }
}
