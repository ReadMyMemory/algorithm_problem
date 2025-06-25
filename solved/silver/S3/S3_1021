package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 뽑아내려는 위치 목록
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 1~N까지 덱에 삽입
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            int target = targets[i];

            // 현재 큐에서 target의 인덱스 구하기
            int idx = 0;
            for (int num : dq) {
                if (num == target) break;
                idx++;
            }

            int left = idx; // 왼쪽으로 이동하는 횟수
            int right = dq.size() - idx; // 오른쪽으로 이동하는 횟수

            // 최소 이동 방향 선택
            if (left <= right) {
                // 왼쪽으로 이동
                for (int j = 0; j < left; j++) {
                    dq.addLast(dq.pollFirst());
                    answer++;
                }
            } else {
                // 오른쪽으로 이동
                for (int j = 0; j < right; j++) {
                    dq.addFirst(dq.pollLast());
                    answer++;
                }
            }
            // 맨 앞(첫 번째 원소) 제거
            dq.pollFirst();
        }
        System.out.println(answer);
    }
}
