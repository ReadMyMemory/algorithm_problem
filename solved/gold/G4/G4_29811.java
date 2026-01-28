package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_29811 {

    static int findMinIndex(TreeSet<Integer>[] buckets) {
        for (int v = 1; v <= 100; v++) {
            if (!buckets[v].isEmpty()) {
                return buckets[v].first();
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1]; // 애지문 -> 대운동장
        int[] B = new int[M + 1]; // 대운동장 -> ITBT관

        @SuppressWarnings("unchecked")
        TreeSet<Integer>[] bucketA = new TreeSet[101];
        @SuppressWarnings("unchecked")
        TreeSet<Integer>[] bucketB = new TreeSet[101];

        for (int i = 1; i <= 100; i++) {
            bucketA[i] = new TreeSet<>();
            bucketB[i] = new TreeSet<>();
        }

        // A 초기값
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            bucketA[A[i]].add(i);
        }

        // B 초기값
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            bucketB[B[i]].add(i);
        }

        // 연산 수
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("U")) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x <= N) {
                    int old = A[x];
                    if (old != y) {
                        bucketA[old].remove(x);
                        A[x] = y;
                        bucketA[y].add(x);
                    }
                } else {
                    int idx = x - N;
                    int old = B[idx];
                    if (old != y) {
                        bucketB[old].remove(idx);
                        B[idx] = y;
                        bucketB[y].add(idx);
                    }
                }
            } else { // L
                int a = findMinIndex(bucketA);
                int bLocal = findMinIndex(bucketB);
                int b = N + bLocal; // 전체 번호로 변환

                sb.append(a).append(' ').append(b).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
