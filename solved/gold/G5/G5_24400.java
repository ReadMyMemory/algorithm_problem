import java.io.*;
import java.util.*;

public class Main {
    static int n, q;
    static int[] A, B;
    static int diff; // A[i] != B[i] 인 개수

    static void checkAndExitIfEqual() {
        if (diff == 0) {
            System.out.print(1);
            System.exit(0);
        }
    }

    static void doSwap(int i, int j) {
        // i==j인 "교환"도 발생 가능 -> 동일 인덱스여도 체크
        if (i == j) {
            checkAndExitIfEqual();
            return;
        }

        boolean bi = (A[i] != B[i]);
        boolean bj = (A[j] != B[j]);

        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;

        boolean ai = (A[i] != B[i]);
        boolean aj = (A[j] != B[j]);

        if (bi != ai) diff += ai ? 1 : -1;
        if (bj != aj) diff += aj ? 1 : -1;

        checkAndExitIfEqual();
    }

    static int partition(int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) { // 모든 원소가 서로 다르지만 의사코드 그대로 사용
                i++;
                doSwap(i, j); // i==j여도 "교환" 처리(상태 체크을 위함)
            }
        }
        if (i + 1 != r) {
            doSwap(i + 1, r);
        }
        return i + 1;
    }

    static void quickSelectCheck(int Q) {
        int p = 0, r = n - 1;
        int qq = Q; // 1-indexed (부분배열에서 q번째)

        while (true) {
            if (p == r) return;

            int t = partition(p, r);
            int k = t - p + 1; // 피벗이 부분배열에서 k번째 작은 원소

            if (qq < k) {
                r = t - 1;
            } else if (qq == k) {
                return;
            } else {
                p = t + 1;
                qq -= k;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        A = new int[n];
        B = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) B[i] = Integer.parseInt(st.nextToken());

        diff = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != B[i]) diff++;
        }

        // 초기 상태도 "과정에서 발생 가능한 경우"로 포함함.
        checkAndExitIfEqual();

        quickSelectCheck(q);

        // 끝까지 동일해진 적 없음
        System.out.print(0);
    }
}
