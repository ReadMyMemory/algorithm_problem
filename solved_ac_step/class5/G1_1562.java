package solved_ac_step.class5;
import java.io.*;

public class G1_1562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int visited = 1 << 10;
        int mod = 1000000000; // 보통 mod는 modulo를 말한다. 모듈로 연산은 숫자를 특정 값으로 나눠 나머지를 계산하는 연산을 말한다.
        long[][][] dp = new long[101][10][visited];
        long answer = 0L;
        for(int i = 1; i <= 9; i++)
            dp[1][i][1<<i] = 1;

        for(int i = 2; i <= N; i++)
            for (int j = 0; j <= 9; j++)
                for(int k = 0; k < visited; k++) {
                    int bit = k | (1<<j); // 비트마스크 로직. k 상태에서 숫자 j를 방문
                    dp[i][j][bit] = (dp[i][j][bit] + ((0 < j ? dp[i-1][j-1][k] : 0) + (j < 9 ? dp[i-1][j+1][k] : 0)) % mod) % mod;
                }

        for(int i = 0; i <= 9; i++)
            answer = (answer + dp[N][i][visited-1]) % mod;

        System.out.println(answer);
    }
}
