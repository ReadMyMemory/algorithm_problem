package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_14891 {
    static int[][] gear = new int[4][8];

    static void rotate(int idx, int dir) {
        if (dir == 0) return;

        if (dir == 1) { // 시계
            int last = gear[idx][7];
            for (int i = 7; i >= 1; i--) gear[idx][i] = gear[idx][i - 1];
            gear[idx][0] = last;
        } else { // 반시계(dir == -1)
            int first = gear[idx][0];
            for (int i = 0; i <= 6; i++) gear[idx][i] = gear[idx][i + 1];
            gear[idx][7] = first;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < 8; j++) gear[i][j] = s.charAt(j) - '0';
        }

        int K = Integer.parseInt(br.readLine().trim());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; // 0-based
            int dir = Integer.parseInt(st.nextToken());

            int[] dirs = new int[4];
            dirs[num] = dir;

            // 왼쪽으로 전파
            for (int i = num - 1; i >= 0; i--) {
                // i의 2번과 i+1의 6번 비교 (회전 적용 전 상태 기준)
                if (gear[i][2] != gear[i + 1][6]) dirs[i] = -dirs[i + 1];
                else break;
            }

            // 오른쪽으로 전파
            for (int i = num + 1; i < 4; i++) {
                if (gear[i - 1][2] != gear[i][6]) dirs[i] = -dirs[i - 1];
                else break;
            }

            // 회전 일괄 적용
            for (int i = 0; i < 4; i++) rotate(i, dirs[i]);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) score += (1 << i);
        }
        System.out.println(score);
    }
}
