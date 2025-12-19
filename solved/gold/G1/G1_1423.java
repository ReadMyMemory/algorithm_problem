package solved.gold.G1;
import java.io.*;
import java.util.*;

public class G1_1423 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        long[] cnt = new long[N + 1];
        long[] power = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) cnt[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) power[i] = Long.parseLong(st.nextToken());

        int D = Integer.parseInt(br.readLine().trim());

        // 초기 힘 합
        long base = 0L;
        for (int i = 1; i <= N; i++) {
            base += cnt[i] * power[i];
        }

        // dp[t] = 훈련을 t일 사용했을 때 얻을 수 있는 "추가 힘"의 최댓값
        long[] dp = new long[D + 1];
        Arrays.fill(dp, 0L);

        // 레벨 i 캐릭터를 "최대 D마리"까지만 고려하면 충분
        for (int i = 1; i <= N - 1; i++) {
            int copies = (int) Math.min(cnt[i], (long) D);
            int L = N - i; // i에서 최대로 올릴 수 있는 횟수

            // 동일 아이템 copies개를 그냥 반복 처리 (D<=100이라 충분히 빠름)
            for (int c = 0; c < copies; c++) {
                long[] next = dp.clone(); // 이번 아이템 반영 후 dp

                for (int used = 0; used <= D; used++) {
                    // k번 훈련해서 i+k가 되는 선택
                    for (int k = 1; k <= L; k++) {
                        if (used + k > D) break;
                        long gain = power[i + k] - power[i]; // k번 올렸을 때 증가량(망원경)
                        next[used + k] = Math.max(next[used + k], dp[used] + gain);
                    }
                }

                dp = next;
            }
        }

        long bestGain = 0L;
        for (int t = 0; t <= D; t++) bestGain = Math.max(bestGain, dp[t]);

        System.out.println(base + bestGain);
    }
}
