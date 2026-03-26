package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_16493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 남은 일 수
        int M = Integer.parseInt(st.nextToken()); // 챕터 수

        int[] dp = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int page = Integer.parseInt(st.nextToken());

            for (int d = N; d >= day; d--) {
                dp[d] = Math.max(dp[d], dp[d - day] + page);
            }
        }
        System.out.println(dp[N]);
    }
}