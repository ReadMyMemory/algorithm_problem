package solved.silver;
import java.io.*;
import java.util.*;
/*
파스칼의 삼각형의 특징
원래 수학에서 이를 계산할 때는 Combination을 알면 쉽다.
예를 들어 5번째 형은 5C0, 5C1, 5C2, 5C3 ... 이런식으로 진행이 된다.
따라서 n번째 행에서 K번째 수를 출력하는 것은 n C (k+1)를 구하는 것과 같다.
다만 조합은 바로 계산하게 되면 overflow 문제가 발생하므로 좀 더 효율적으로 계산할 필요가 있다.
따라서 이번엔 파스칼의 삼각형 원래의 특징을 이용한 dp로 풀어보려고 한다.
원래의 특징에 따라 점화식은 dp[n][k] = dp[n-1][k-1] + dp[n-1][k] 다.
 */
public class S5_16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[31][31];
        dp[1][1] = 1;
        /*
        삼각형의 양끝을 생각할 필요가 없는 건 어쩌피 n열의 첫 값(dp[n][1])은 dp[n-1][0]과 dp[n-1][1]의 합일 것이고
        dp[n-1][0]은 따로 초기화를 하지 않아서 값이 0이다. 따라서 0 + 1  = 1 이 된다.
        */
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        System.out.println(dp[n][k]);
    }
}
