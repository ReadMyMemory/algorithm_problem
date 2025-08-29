package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_12026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String blocks = br.readLine();

        // dp[i] = i번째 블록까지 가는데 필요한 최소 에너지
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 시작점

        // BOJ 패턴 정의
        char[] pattern = {'B', 'O', 'J'};

        // 각 위치에서 다음 위치로 점프
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // i번째 위치에 도달 불가능

            char current = blocks.charAt(i);
            char next;

            // 현재 문자에 따라 다음에 와야 할 문자 결정
            if (current == 'B') next = 'O';
            else if (current == 'O') next = 'J';
            else next = 'B'; // J 다음은 B

            // i+1부터 n-1까지 점프 가능
            for (int j = i + 1; j < n; j++) {
                if (blocks.charAt(j) == next) {
                    int distance = j - i;
                    int energy = distance * distance;
                    dp[j] = Math.min(dp[j], dp[i] + energy);
                }
            }
        }

        // 결과 출력
        if (dp[n-1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n-1]);
        }
    }
}