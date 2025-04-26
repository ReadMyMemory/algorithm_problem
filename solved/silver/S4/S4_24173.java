package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_24173 {
    static int N;
    static long K, count = 0;
    static int[] A;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        buildMinHeap();
        for (int i = N; i >= 2; i--) {
            swap(1, i);
            heapify(1, i - 1);
        }

        // K번째 교환이 발생하지 않았으면 -1 출력
        bw.write("-1");
        bw.newLine();
        bw.flush();
    }

    static void buildMinHeap() throws IOException {
        for (int i = N / 2; i >= 1; i--) {
            heapify(i, N);
        }
    }

    static void heapify(int k, int n) throws IOException {
        while (true) {
            int left = k * 2;
            int right = left + 1;
            int smaller;

            if (right <= n) {
                smaller = (A[left] < A[right]) ? left : right;
            } else if (left <= n) {
                smaller = left;
            } else {
                break;
            }

            if (A[smaller] < A[k]) {
                swap(k, smaller);
                k = smaller;
            } else {
                break;
            }
        }
    }

    static void swap(int i, int j) throws IOException {
        int x = A[i], y = A[j];
        A[i] = y;
        A[j] = x;
        count++;
        if (count == K) {
            // K번째 교환된 두 수를 작은 수부터 출력
            bw.write(Math.min(x, y) + " " + Math.max(x, y));
            bw.newLine();
            bw.flush();
            System.exit(0);
        }
    }
}
