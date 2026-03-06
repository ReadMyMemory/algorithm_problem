package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_13335 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 다리 최대 하중

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.offer(0); // 처음엔 다리 위가 비어 있음
        }

        int time = 0;
        int idx = 0;
        int currentWeight = 0;

        while (idx < n) {
            time++;

            // 한 칸 전진: 맨 앞 트럭(또는 빈 칸) 빠짐
            currentWeight -= bridge.poll();

            // 다음 트럭을 올릴 수 있으면 올리고, 아니면 0(빈 칸) 넣기
            if (currentWeight + trucks[idx] <= L) {
                bridge.offer(trucks[idx]);
                currentWeight += trucks[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        time += w;
        System.out.println(time);
    }
}