package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        // 스택에는 {인덱스(1-based), 높이} 저장
        Deque<int[]> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            int idx = i + 1; // 1-based 인덱스

            // 현재 탑보다 작거나 같은 탑은 신호를 못 받으니 제거
            while (!stack.isEmpty() && stack.peek()[1] <= height) {
                stack.pop();
            }

            // 스택이 비어있지 않으면 맨 위 탑이 수신 탑
            if (!stack.isEmpty()) {
                answer[i] = stack.peek()[0];
            } else {
                answer[i] = 0;
            }

            // 현재 탑을 스택에 추가
            stack.push(new int[]{idx, height});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]);
            if (i < N - 1) sb.append(' ');
        }
        System.out.print(sb.toString());
    }
}
