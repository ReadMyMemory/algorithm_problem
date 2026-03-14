package solved.silver.S2;
import java.io.*;
import java.math.*;

public class S2_1793 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.valueOf(3);

        for (int i = 3; i <= 250; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}