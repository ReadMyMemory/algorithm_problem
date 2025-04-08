package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 학생 수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 최대 힙: 가장 낮은 7개의 점수를 유지
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(7, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            double score = Double.parseDouble(br.readLine());

            if (maxHeap.size() < 7) {
                maxHeap.offer(score);
            } else if (score < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(score);
            }
        }

        // 힙은 순서가 정렬되어 있지 않기 때문에 Stack에 담아 정렬
        Stack<Double> stack = new Stack<>();
        while (!maxHeap.isEmpty()) {
            stack.push(maxHeap.poll());
        }

        while (!stack.isEmpty()) {
            System.out.printf("%.3f\n", stack.pop());
        }
    }
}
