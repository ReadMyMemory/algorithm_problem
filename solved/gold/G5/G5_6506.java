package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_6506 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) break;

            int[] a = new int[n];
            int idx = 0;

            // 수열 입력은 여러 줄에 걸쳐 올 수 있으므로 토큰을 n개 채울 때까지 읽기
            st = new StringTokenizer("");
            while (idx < n) {
                while (!st.hasMoreTokens()) {
                    line = br.readLine();
                    st = new StringTokenizer(line);
                }
                a[idx++] = Integer.parseInt(st.nextToken());
            }

            long[][] dp = new long[k + 1][n];

            for (int i = 0; i < n; i++) dp[1][i] = 1;

            for (int len = 2; len <= k; len++) {
                for (int i = 0; i < n; i++) {
                    long sum = 0;
                    for (int j = 0; j < i; j++) {
                        if (a[j] < a[i]) sum += dp[len - 1][j];
                    }
                    dp[len][i] = sum;
                }
            }

            long ans = 0;
            for (int i = 0; i < n; i++) ans += dp[k][i];

            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}