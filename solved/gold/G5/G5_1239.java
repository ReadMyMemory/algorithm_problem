package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_1239 {
    static int n;
    static int[] values;
    static int maxLines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        values = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        maxLines = 0;

        // 모든 순열을 시도
        permute(0);

        System.out.println(maxLines);
    }

    static void permute(int depth) {
        if (depth == n) {
            // 현재 배치에서 중심선 개수 계산
            int lines = countLines();
            maxLines = Math.max(maxLines, lines);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(depth, i);
            permute(depth + 1);
            swap(depth, i);
        }
    }

    static void swap(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    static int countLines() {
        int count = 0;
        int sum = 0;

        // 각 시작점에서 누적합이 50이 되는지 확인
        for (int start = 0; start < n; start++) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                int idx = (start + i) % n;
                sum += values[idx];

                // 정확히 50 (180도)이 되면 중심선 발견
                if (sum == 50) {
                    count++;
                    break;
                }

                // 50을 넘으면 이 시작점에서는 불가능
                if (sum > 50) {
                    break;
                }
            }
        }

        // 각 중심선은 양쪽에서 카운트되므로 2로 나눔
        return count / 2;
    }
}