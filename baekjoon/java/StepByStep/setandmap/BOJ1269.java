package StepByStep.setandmap;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numB; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int result = getSetDiff(setA, setB) + getSetDiff(setB, setA);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getSetDiff(Set<Integer> A, Set<Integer> B) {
        Set<Integer> result = new HashSet<>(A);
        result.removeAll(B);

        return result.size();
    }
}
