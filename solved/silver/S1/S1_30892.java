package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_30892 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());  // long 타입 주의

        int[] sharks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sharks); // 상어 크기 오름차순 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

        int idx = 0;
        long cur = T;
        for (int eaten = 0; eaten < K; eaten++) {
            // 현재 크기보다 작은 상어들을 모두 힙에 추가
            while (idx < N && sharks[idx] < cur) {
                pq.add(sharks[idx]);
                idx++;
            }

            // 먹을 수 있는 상어가 없다면 종료
            if (pq.isEmpty()) break;

            // 가장 큰 상어를 먹음
            cur += pq.poll();
        }
        System.out.println(cur);
    }
}

