package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_15655 {
    static int N, M;
    static int[] arr;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(pick[i]);
                if (i + 1 < M) sb.append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            pick[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        pick = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.print(sb.toString());
    }
}
