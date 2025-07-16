package solved.gold;
import java.io.*;
// 재귀와 DP로 푸는 문제

public class G5_2591 {
    static String s;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        dp = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) dp[i] = -1;

        System.out.println(dfs(0));
    }

    static int dfs(int idx) {
        if (idx == s.length()) return 1;
        if (dp[idx] != -1) return dp[idx];

        int count = 0;

        // 1자리 숫자 확인
        if (s.charAt(idx) != '0') {
            int oneDigit = s.charAt(idx) - '0';
            if (1 <= oneDigit && oneDigit <= 9) {
                count += dfs(idx + 1);
            }
        }

        // 2자리 숫자 확인
        if (idx + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(idx, idx + 2));
            if (10 <= twoDigit && twoDigit <= 34) {
                count += dfs(idx + 2);
            }
        }

        dp[idx] = count;
        return count;
    }
}
