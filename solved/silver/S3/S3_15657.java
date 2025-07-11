package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_15657 {
    static int N, M;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 사전순 출력을 위해 정렬

        dfs(0, 0);
        System.out.print(sb);
    }

    // start: 현재 위치 이후로만 뽑아야 비내림차순 됨
    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            result[depth] = arr[i];
            dfs(depth + 1, i); // i부터 시작 (중복 가능, 비내림차순 보장)
        }
    }
}
