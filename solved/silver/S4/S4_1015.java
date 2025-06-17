package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_1015 {
    static class Pair implements Comparable<Pair> {
        int value, idx;
        Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
        public int compareTo(Pair o) {
            // 값 오름차순, 값이 같으면 인덱스 오름차순
            if (this.value != o.value)
                return this.value - o.value;
            return this.idx - o.idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Pair[] arr = new Pair[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Pair(A[i], i);
        }
        Arrays.sort(arr); // 값, 인덱스 기준 정렬

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            // arr[i].idx는 A에서의 인덱스, i는 B에서의 인덱스
            P[arr[i].idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]);
            if (i != N-1) sb.append(" ");
        }
        System.out.println(sb);
    }
}