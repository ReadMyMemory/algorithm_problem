package Arena.season17;
import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String S = scanner.next();

        // dp 배열 초기화
        // dp[i][j]: S의 i부터 j까지의 부분 문자열이 올바른 괄호 문자열이 되는지 여부를 저장
        boolean[][] dp = new boolean[N][N];

        // 길이가 1인 문자열은 항상 올바른 괄호 문자열이 아님
        for (int i = 0; i < N; i++) {
            dp[i][i] = false;
        }

        // 길이가 2인 문자열은 ()일 때만 올바른 괄호 문자열
        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = (S.charAt(i) == '(' && S.charAt(i + 1) == ')');
        }

        // 길이가 3 이상인 문자열에 대해 DP 채우기
        for (int len = 3; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;

                // 첫 번째와 마지막 문자가 서로 짝이 맞고, 나머지 부분이 올바른 괄호 문자열일 때
                dp[i][j] = (S.charAt(i) == '(' && S.charAt(j) == ')' && dp[i + 1][j - 1]);

                // 중간에 나뉘어진 두 부분이 각각 올바른 괄호 문자열일 때
                for (int k = i; k < j; k++) {
                    dp[i][j] |= (dp[i][k] && dp[k + 1][j]);
                }
            }
        }

        // 결과 출력
        if (dp[0][N - 1]) {
            System.out.println("jimin");
        } else {
            System.out.println("junhui");
        }
    }
}

