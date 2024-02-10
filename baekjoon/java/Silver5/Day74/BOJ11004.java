package Silver5.Day74;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11004 {
    static int[] A;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(0, N - 1);
        System.out.println(A[K - 1]);


    }
    private static void quickSort(int S, int E) {
        if(S < E) {
            int index = partition(S, E);
            if(index == K - 1) {
                return;
            }else if(index < K - 1) {
                quickSort(index + 1, E);
            }else {
                quickSort(S, index - 1);
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
