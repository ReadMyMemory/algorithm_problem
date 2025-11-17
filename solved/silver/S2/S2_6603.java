package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_6603 {
    static int k;
    static int[] arr;       // 입력 숫자들
    static int[] select = new int[6]; // 선택한 6개 조합을 담는 배열
    static StringBuilder sb = new StringBuilder();

    // depth: 현재까지 선택한 개수, start: 다음에 선택할 인덱스 시작점
    static void dfs(int depth, int start) {
        // 6개를 모두 선택한 경우 출력
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                if (i > 0) sb.append(' ');
                sb.append(select[i]);
            }
            sb.append('\n');
            return;
        }

        // 조합 생성: 이전에 선택한 인덱스 이후부터 탐색
        for (int i = start; i < k; i++) {
            select[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean firstCase = true;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());

            // 0이면 입력 종료
            if (k == 0) break;

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 테스트 케이스 사이에 빈 줄 한 줄
            if (!firstCase) {
                sb.append('\n');
            }
            firstCase = false;

            dfs(0, 0);
        }
        System.out.print(sb);
    }
}
