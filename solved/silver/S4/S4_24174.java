package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_24174 {
    static int N, K, swapCount = 0;
    static int[] A;
    static boolean printed = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1]; // 1-based index

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        heapSort();

        // 교환 횟수가 K보다 적은 경우
        if (!printed) {
            System.out.println(-1);
        }
    }

    static void heapSort() {
        buildMinHeap();
        for (int i = N; i >= 2; i--) {
            swap(1, i);
            if (printed) return;
            heapify(1, i - 1);
            if (printed) return;
        }
    }

    static void buildMinHeap() {
        for (int i = N / 2; i >= 1; i--) {
            heapify(i, N);
            if (printed) return;
        }
    }

    static void heapify(int k, int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller;

        if (right <= n) {
            if (A[left] < A[right]) smaller = left;
            else smaller = right;
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if (A[smaller] < A[k]) {
            swap(k, smaller);
            if (printed) return;
            heapify(smaller, n);
        }
    }

    static void swap(int i, int j) {
        swapCount++;
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        if (swapCount == K) {
            printArray();
            printed = true;
        }
    }

    static void printArray() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(A[i]);
            if (i < N) sb.append(" ");
        }
        System.out.println(sb);
    }
}
