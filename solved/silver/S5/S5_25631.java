package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_25631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dolls = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dolls);

        // 최소 힙: 각 체인의 마지막 값을 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int size : dolls) {
            if (!pq.isEmpty() && pq.peek() < size) {
                pq.poll(); // 가장 작은 체인에 넣는다
            }
            pq.add(size); // 새 체인을 시작하거나 체인에 추가
        }

        // 남아있는 체인의 개수가 최소 마트료시카 개수
        System.out.println(pq.size());
    }
}
