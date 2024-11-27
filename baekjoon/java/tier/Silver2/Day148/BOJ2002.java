package Silver2.Day148;

import java.io.*;
import java.util.HashMap;

public class BOJ2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++)
            map.put(br.readLine(), i);

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++)
            arr[i] = map.get(br.readLine());

        int cnt = 0;

        for(int i = 1; i< N; i++){
            for(int j = i + 1; j <= N; j++){
                if(arr[i] > arr[j]){
                    cnt++;
                    break;
                }
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
