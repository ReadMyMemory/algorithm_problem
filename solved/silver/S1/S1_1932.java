package solved.silver.S1;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 삼각형 크기 입력
        int n = Integer.parseInt(br.readLine());
        
        // 삼각형 배열 생성 및 입력
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // DP 배열 생성 (메모이제이션)
        int[][] dp = new int[n][n];
        
        // 맨 위층 초기화
        dp[0][0] = triangle[0][0];
        
        // 위에서부터 아래로 내려가며 최대값 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 왼쪽 대각선에서 내려오는 경우
                if (j > 0) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                
                // 오른쪽 대각선에서 내려오는 경우
                if (j < i) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + triangle[i][j]);
                }
            }
        }
        
        // 마지막 층에서 최대값 찾기
        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, dp[n-1][j]);
        }
        System.out.println(maxSum);
    }
}
