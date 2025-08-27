package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int scenario = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            // 여학생 이름 저장
            String[] names = new String[n + 1]; // 1부터 시작하므로 n+1 크기
            for (int i = 1; i <= n; i++) {
                names[i] = br.readLine();
            }

            // 각 여학생의 귀걸이 상태 추적
            // Map을 사용하여 각 번호가 나타난 횟수를 카운트
            Map<Integer, Integer> count = new HashMap<>();

            // 2n-1개의 기록 읽기
            for (int i = 0; i < 2 * n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int studentNum = Integer.parseInt(st.nextToken());
                String letter = st.nextToken(); // A 또는 B (사용하지 않음)

                // 해당 번호의 등장 횟수 증가
                count.put(studentNum, count.getOrDefault(studentNum, 0) + 1);
            }

            // 한 번만 나타난 번호 찾기 (귀걸이를 돌려받지 못한 학생)
            int lostStudent = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (entry.getValue() == 1) {
                    lostStudent = entry.getKey();
                    break;
                }
            }

            // 결과 출력
            sb.append(scenario).append(" ").append(names[lostStudent]).append("\n");
            scenario++;
        }
        System.out.print(sb.toString());
    }
}