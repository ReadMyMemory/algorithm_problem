package solved.bronze.B1;
import java.io.*;
import java.math.BigInteger;

public class B1_4150 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 1)
            System.out.println(1);
        else {
            BigInteger[] dp = new BigInteger[N + 1];
            dp[1] = BigInteger.valueOf(1);
            dp[2] = BigInteger.valueOf(1);
            for (int i = 3; i <= N; i++)
                dp[i] = dp[i - 1].add(dp[i - 2]);
            System.out.println(dp[N]);
        }
    }
}
