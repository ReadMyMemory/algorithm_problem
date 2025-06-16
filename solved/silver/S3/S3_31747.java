package solved.silver.S3;
import java.io.*;
import java.util.*;

// 40점 맞음. 나중에 수정해야함.

public class S3_31747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 1, 2학년 인덱스 저장
        ArrayDeque<Integer> oneIdx = new ArrayDeque<>();
        ArrayDeque<Integer> twoIdx = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (A[i] == 1) oneIdx.add(i);
            else twoIdx.add(i);
        }

        int time = 0;
        int front = 0;
        int remain = N;

        while (remain > 0) {
            int limit = front + K;
            // 앞에서 K명 이내에 1학년, 2학년 인덱스 있는지
            while (!oneIdx.isEmpty() && oneIdx.peek() < front) oneIdx.poll();
            while (!twoIdx.isEmpty() && twoIdx.peek() < front) twoIdx.poll();
            boolean oneExist = (!oneIdx.isEmpty() && oneIdx.peek() < limit);
            boolean twoExist = (!twoIdx.isEmpty() && twoIdx.peek() < limit);

            if (oneExist && twoExist) {
                oneIdx.poll();
                twoIdx.poll();
                remain -= 2;
                front++;
            } else if (oneExist) {
                oneIdx.poll();
                remain--;
                front++;
            } else if (twoExist) {
                twoIdx.poll();
                remain--;
                front++;
            }
            time++;
        }
        System.out.println(time);
    }
}
