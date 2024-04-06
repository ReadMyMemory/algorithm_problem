package solved.silver;
import java.io.*;
import java.util.StringTokenizer;

// 점화식을 세워서 푸는 대표적인 dp 문제.
// R, G, B 3개로 나눠서 하는 게 좋겠다.
// 이전까지의 비용이 최솟값이었다고 다음 색깔을 칠했을 때 그때도 최솟값이라는 보장이 없다.
// 따라서 한 색깔로 관점을 고정하면 이전 색깔엔 두 가지 색깔이 나올 수 있었으니 이 두 가지 색깔에 현 색깔의 가중치를 더해 그 중에 최솟값을 구하면 된다.
// 예를 들어 dp[i][0]의 경우, dp[i][0]는 weight[i-1][1] + weight[i][0] 과 weight[i-1][2] + weight[i][0] 중 작은 값일 것이다.
//즉 dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + weight[i][0] 인 것이다.
//마찬가지로 dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + weight[i][1]
// dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + weight[i][2] 다.

public class S1_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. 집의 수 입력받고, 그 값을 기준으로 배열 생성
        int N = Integer.parseInt(br.readLine());
        int[][] weight = new int[N+1][3]; // 색 비용 weight
        int[][] dp = new int[N+1][3]; // 최솟값 구하기 dp

        //2. 초기 값 선정 및 가중치 값 받기
        dp[0][0] = weight[0][0] = 0;
        dp[0][1] = weight[0][1] = 0;
        dp[0][2] = weight[0][2] = 0;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i][0] = Integer.parseInt(st.nextToken()); //Red
            weight[i][1] = Integer.parseInt(st.nextToken()); //Green
            weight[i][2] = Integer.parseInt(st.nextToken()); //Blue
        }

        //3. 최솟값 구하기
        for(int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + weight[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + weight[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + weight[i][2];
        }

        //4. 3가지 경우의 수 중 최솟값 출력
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}

