package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_2643 {
    static class Paper implements Comparable<Paper> {
        int width, height;

        Paper(int a, int b) {
            // 작은 값을 width, 큰 값을 height로 정규화
            this.width = Math.min(a, b);
            this.height = Math.max(a, b);
        }

        @Override
        public int compareTo(Paper other) {
            // 오름차순 정렬: width 우선, height 보조
            if (this.width != other.width) {
                return this.width - other.width;
            }
            return this.height - other.height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // n이 0인 경우 처리
        if (n == 0) {
            System.out.println(0);
            br.close();
            return;
        }

        Paper[] papers = new Paper[n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            papers[i] = new Paper(a, b);
        }

        // 정렬 (작은 종이부터 - 오름차순)
        Arrays.sort(papers);

        // dp[i] = i번째 종이를 맨 아래로 했을 때 그 위에 쌓을 수 있는 최대 개수
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // 모든 원소를 1로 초기화
        int maxCount = 1;  // 최소 1개는 놓을 수 있음

        // 각 종이에 대해 DP 계산
        for (int i = 0; i < n; i++) {
            // i번째 종이 위에 j번째 종이를 올릴 수 있는지 확인
            for (int j = 0; j < i; j++) {
                // j번째 종이를 i번째 종이 위에 올릴 수 있는지 확인
                if (papers[i].width >= papers[j].width && papers[i].height >= papers[j].height) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxCount = Math.max(maxCount, dp[i]);
        }
        System.out.println(maxCount);
    }
}