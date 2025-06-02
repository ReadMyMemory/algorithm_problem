package solved.silver.S3;
import java.io.*;
import java.util.*;

/*
자바에서 기본 제공하는 우선순위 큐는 최소 힙이니까, 최대 힙으로 바꿔야함.
 */

public class S3_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Collections.reverseOrder()를 써도 되는 듯.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 최대 힙

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                // 아이를 만남: 선물 꺼내주기
                if (pq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(pq.poll()+"\n");
                }
            } else {
                // 거점지: a개의 선물 충전
                for (int j = 0; j < a; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
