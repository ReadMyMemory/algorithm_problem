package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_28422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i]: 0~i번째 카드까지 고려했을 때 얻을 수 있는 최대 점수
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MIN_VALUE); // 매우 작은 값으로 초기화
        dp[0] = 0; // 아무것도 안가져간 상태

        for (int i = 2; i <= N; i++) {
            // 2장을 가져가는 경우
            int xor2 = cards[i - 2] ^ cards[i - 1];
            int score2 = Integer.bitCount(xor2);
            if (dp[i - 2] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - 2] + score2);
            }

            // 3장을 가져가는 경우
            if (i >= 3) {
                int xor3 = cards[i - 3] ^ cards[i - 2] ^ cards[i - 1];
                int score3 = Integer.bitCount(xor3);
                if (dp[i - 3] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - 3] + score3);
                }
            }
        }

        // 마지막 카드 1장 남는 경우 0점 (dp[N-1]은 쓸모 없음!)
        int answer = Math.max(dp[N], 0);
        System.out.println(answer);
    }
}
