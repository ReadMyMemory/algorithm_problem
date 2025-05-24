package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_24268 {
    static int N, d;
    static int answer = -1;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int[] digits = new int[d];
        for (int i = 0; i < d; i++) digits[i] = i;

        // 모든 순열 탐색 (사전순)
        permute(digits, 0);

        System.out.println(answer);
    }

    // 순열을 돌면서 조건 만족하는 수를 찾으면 answer 갱신
    static void permute(int[] arr, int depth) {
        if (depth == arr.length) {
            // 맨 앞이 0이면 안됨
            if (arr[0] == 0) return;
            int val = toDecimal(arr);
            if (val > N) {
                if (!found || val < answer) {
                    answer = val;
                    found = true;
                }
            }
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // d진법 -> 10진법 변환
    static int toDecimal(int[] arr) {
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            val = val * d + arr[i];
        }
        return val;
    }
}
