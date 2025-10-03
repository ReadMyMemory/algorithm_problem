package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_15666 {
    static int N, M;
    static int[] numbers;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 및 중복 제거
        Arrays.sort(numbers);
        numbers = Arrays.stream(numbers).distinct().toArray();
        N = numbers.length;

        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = numbers[i];
            dfs(depth + 1, i);
        }
    }
}