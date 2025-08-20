package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        long[][] dp = new long[n][n];

        // 게임판 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작점에서 시작
        dp[0][0] = 1;

        // 각 칸을 순서대로 방문하면서 경로의 개수 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 칸에 도달할 수 있는 경로가 없으면 건너뛰기
                if (dp[i][j] == 0) continue;

                // 도착점에 도달한 경우 건너뛰기
                if (i == n - 1 && j == n - 1) continue;

                int jump = board[i][j];

                // 오른쪽으로 점프
                if (j + jump < n) {
                    dp[i][j + jump] += dp[i][j];
                }

                // 아래로 점프
                if (i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }
            }
        }
        // 도착점까지 가는 경로의 개수 출력
        System.out.println(dp[n - 1][n - 1]);
    }
}