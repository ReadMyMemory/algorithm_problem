package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_2116 {
    static int n;
    static int[][] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dice = new int[n][6];

        // 주사위 정보 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;

        // 첫 번째 주사위의 각 면이 바닥이 되는 경우를 모두 시도
        for (int bottom = 0; bottom < 6; bottom++) {
            int sum = 0;
            int bottomValue = dice[0][bottom];
            int topValue = dice[0][getOpposite(bottom)];

            // 첫 번째 주사위의 옆면 중 최댓값
            sum += getMaxSide(0, bottom, getOpposite(bottom));

            // 나머지 주사위들 처리
            for (int i = 1; i < n; i++) {
                // 이전 주사위의 윗면 값과 같은 값을 가진 면을 찾기
                int currentBottom = -1;
                for (int j = 0; j < 6; j++) {
                    if (dice[i][j] == topValue) {
                        currentBottom = j;
                        break;
                    }
                }

                int currentTop = getOpposite(currentBottom);
                topValue = dice[i][currentTop];

                // 현재 주사위의 옆면 중 최댓값
                sum += getMaxSide(i, currentBottom, currentTop);
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }

    // 마주보는 면의 인덱스 반환
    static int getOpposite(int idx) {
        switch(idx) {
            case 0: return 5;  // A-F
            case 1: return 3;  // B-D
            case 2: return 4;  // C-E
            case 3: return 1;  // D-B
            case 4: return 2;  // E-C
            case 5: return 0;  // F-A
            default: return -1;
        }
    }

    // 주사위의 윗면과 아랫면을 제외한 옆면 중 최댓값 반환
    static int getMaxSide(int diceIdx, int bottom, int top) {
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (i != bottom && i != top) {
                max = Math.max(max, dice[diceIdx][i]);
            }
        }
        return max;
    }
}