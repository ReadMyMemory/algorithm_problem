package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_25706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N + 1];

        // 뒤에서부터 계산
        for (int i = N; i >= 1; i--) {
            if (h[i] == 0) {
                // 점프대가 없는 경우: 다음 칸으로 이동
                if (i + 1 <= N) {
                    answer[i] = answer[i + 1] + 1;
                } else {
                    answer[i] = 1;
                }
            } else {
                // 점프대가 있는 경우: h[i]칸을 건너뛰고 착지
                int nextPos = i + h[i] + 1;
                if (nextPos <= N) {
                    answer[i] = answer[nextPos] + 1;
                } else {
                    answer[i] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]);
            if (i < N) sb.append(" ");
        }
        System.out.println(sb);
    }
}