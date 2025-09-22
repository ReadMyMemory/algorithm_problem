package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 원본 좌표 저장
        int[] original = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬을 위한 복사본 생성
        int[] sorted = original.clone();
        Arrays.sort(sorted);

        // 중복 제거하면서 압축된 좌표값 매핑
        Map<Integer, Integer> compressed = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < n; i++) {
            // 이미 처리된 값이 아닌 경우에만 순위 부여
            if (!compressed.containsKey(sorted[i])) {
                compressed.put(sorted[i], rank);
                rank++;
            }
        }

        // 원본 순서대로 압축된 좌표값 출력
        for (int i = 0; i < n; i++) {
            sb.append(compressed.get(original[i])).append(" ");
        }
        System.out.println(sb);
    }
}