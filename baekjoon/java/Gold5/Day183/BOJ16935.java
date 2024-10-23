package Gold5.Day183;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16935 {
    private static int N, M, R;
    private static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (R-- > 0) {
            int num = Integer.parseInt(st.nextToken());

            executeOperation(num);
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void executeOperation(int option) {
        switch (option) {
            case 1:
                executeOp1();
                break;
            case 2:
                executeOp2();
                break;
            case 3:
                executeOp3();
                break;
            case 4:
                executeOp4();
                break;
            case 5:
                executeOp5();
                break;
            case 6:
                executeOp6();
                break;
        }
    }

    private static void executeOp1() {
        int[][] copyArr = new int[N][M];

        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                copyArr[n][m] = A[N - 1 - n][m];

        for (int i = 0; i < N; i++)
            A[i] = Arrays.copyOf(copyArr[i], copyArr[i].length);
    }

    private static void executeOp2() {
        int[][] copyArr = new int[N][M];

        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                copyArr[n][m] = A[n][M - 1 - m];

        for (int i = 0; i < N; i++)
            A[i] = Arrays.copyOf(copyArr[i], copyArr[i].length);
    }

    private static void executeOp3() {
        int[][] copyArr = new int[M][N];

        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                copyArr[m][n] = A[N - 1 - n][m];

        A = new int[M][N];

        for (int i = 0; i < M; i++)
            A[i] = Arrays.copyOf(copyArr[i], copyArr[i].length);

        convert();
    }

    private static void executeOp4() {
        int[][] copyArr = new int[M][N];

        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                copyArr[m][n] = A[n][M - 1 - m];

        A = new int[M][N];

        for (int i = 0; i < M; i++)
            A[i] = Arrays.copyOf(copyArr[i], copyArr[i].length);

        convert();
    }

    private static void convert() {
        int temp = N;
        N = M;
        M = temp;
    }

    private static void executeOp5() {
        int[][] copyArr = new int[N][M];

        int halfColumn = N / 2;
        int halfRow = M / 2;

        for (int i = 0; i < halfColumn; i++)
            for (int j = 0; j < halfRow; j++)
                copyArr[i][j + halfRow] = A[i][j];

        for (int i = 0; i < halfColumn; i++)
            for (int j = halfRow; j < M; j++)
                copyArr[i + halfColumn][j] = A[i][j];

        for (int i = halfColumn; i < N; i++)
            for (int j = halfRow; j < M; j++)
                copyArr[i][j - halfRow] = A[i][j];

        for (int i = halfColumn; i < N; i++)
            for (int j = 0; j < halfRow; j++)
                copyArr[i - halfColumn][j] = A[i][j];

        for (int i = 0; i < N; i++)
            A[i] = Arrays.copyOf(copyArr[i], copyArr[i].length);
    }

    private static void executeOp6() {
        int[][] copyArr = new int[N][M];

        int halfColumn = N / 2;
        int halfRow = M / 2;

        for (int i = 0; i < halfColumn; i++)
            for (int j = 0; j < halfRow; j++)
                copyArr[i + halfColumn][j] = A[i][j];

        for (int i = halfColumn; i < N; i++)
            for (int j = 0; j < halfRow; j++)
                copyArr[i][j + halfRow] = A[i][j];

        for (int i = halfColumn; i < N; i++)
            for (int j = halfRow; j < M; j++)
                copyArr[i - halfColumn][j] = A[i][j];

        for (int i = 0; i < halfColumn; i++)
            for (int j = halfRow; j < M; j++)
                copyArr[i][j - halfRow] = A[i][j];

        for (int i = 0; i < N; i++)
            A[i] = Arrays.copyOf(copyArr[i], copyArr[i].length);
    }
}
