package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];  // 상담 기간
        int[] P = new int[N + 1];  // 상담 금액
        int[] dp = new int[N + 2]; // i일부터 얻을 수 있는 최대 수익

        // 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서부터 계산 (역방향 DP)
        for (int i = N; i >= 1; i--) {
            // i일에 상담을 완료할 수 있는 날짜
            int endDay = i + T[i];

            // N+1일 이후에 끝나면 상담 불가능
            if (endDay > N + 1) {
                dp[i] = dp[i + 1];  // 이 상담을 하지 않고 다음 날의 최대 수익을 그대로 가져옴
            } else {
                // 상담을 하는 경우와 하지 않는 경우 중 최대값
                dp[i] = Math.max(dp[i + 1], P[i] + dp[endDay]);
            }
        }
        System.out.println(dp[1]);
    }
}