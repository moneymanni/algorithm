package doit.day203;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11004 {

    private static int N, K;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);
        bw.write(A[K - 1] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void quickSort(int S, int E) {
        if(S < E) {
            int pivot = partition(S, E);

            if(pivot == K - 1) {
                return;
            }else if(pivot < K - 1) {
                quickSort(pivot + 1, E);
            }else {
                quickSort(S, pivot - 1);
            }
        }
    }

    private static int partition(int S, int E) {
        if(S + 1 == E) {
            if(A[S] > A[E])
                swap(S, E);
            return E;
        }

        int M = (S + E) / 2;
        swap(S, M);

        int i = S + 1;
        int j = E;
        int pivot = A[S];

        while(i <= j) {
            while(j >= S + 1 && pivot < A[j]) {
                j--;
            }
            while(i <= E && pivot > A[i]) {
                i++;
            }
            if(i <= j) {
                swap(i++, j--);
            }
        }

        swap(S, j);
        return j;
    }

    private static void swap(int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
