package Gold5.Day172;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1717 {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        SetCollection set = new SetCollection(n);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (operation == 0)
                set.union(a, b);
            else if (operation == 1)
                sb.append((set.isSameParent(a, b) ? "YES" : "NO")).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}

class SetCollection {
    int[] element;

    public SetCollection(int length) {
        element = new int[length + 1];

        for (int i = 1; i <= length; i++)
            element[i] = i;
    }

    public int find(int x) {
        if (x == element[x])
            return x;

        return element[x] = find(element[x]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y)
                element[y] = x;
            else
                element[x] = y;
        }
    }

    public boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
