package solved.silver.S3;
import java.io.*;

public class S3_1788 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // F(0) = 0 처리
        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        int absN = Math.abs(n);

        // 피보나치 절댓값 구하기 (0 ~ |n|)
        int[] dp = new int[absN + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= absN; i++) {
            dp[i] = (int)(((long)dp[i - 1] + dp[i - 2]) % MOD);
        }

        // 부호 계산
        int sign;
        if (n > 0) {
            sign = 1;          // 양수 인덱스는 항상 양수 (n>0이면 F(n)>0)
        } else {
            // F(-n) = (-1)^(n+1) * F(n)
            // n < 0 일 때 |n|이 짝수면 음수, 홀수면 양수
            if (absN % 2 == 0) sign = -1;
            else sign = 1;
        }
        System.out.println(sign);
        System.out.println(dp[absN]);  // 이미 MOD로 계산된 절댓값
    }
}
