package solved.gold.G4;
import java.io.*;

// dp를 이용해서 그런걸까? 생각보다 어렵지는 않았던 것 같다.

public class G4_1915 {
    public static void main(String[] args) throws IOException {

        // 선언부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] board = new int[n][m];
        int[][] dp = new int[n][m];
        int max = 0;

        // 입력부
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
                dp[i][j] = board[i][j];
            }
        }

        // dp 수행부
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && i > 0 && j > 0) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                if (dp[i][j] > max) max = dp[i][j];
            }
        }

        //출력부
        System.out.println(max * max);
    }
}
