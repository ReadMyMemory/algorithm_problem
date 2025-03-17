package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_23969 {
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

        int swapCount = 0;
        boolean swapped;

        for (int last = N - 1; last > 0; last--) {
            swapped = false;
            for (int i = 0; i < last; i++) {
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    swapCount++;
                    swapped = true;

                    if (swapCount == K) {
                        printArray(A);
                        return;
                    }
                }
            }
            if (!swapped) break; // 이미 정렬된 상태
        }

        System.out.println(-1);
    }

    private static void printArray(int[] A) {
        StringBuilder sb = new StringBuilder();
        for (int num : A) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
