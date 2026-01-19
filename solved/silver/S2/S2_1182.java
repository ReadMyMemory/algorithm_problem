package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1182 {
    static int N, S;
    static int[] arr;
    static int count = 0;

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) count++;
            return;
        }

        // 1) idx 원소를 포함한다
        dfs(idx + 1, sum + arr[idx]);

        // 2) idx 원소를 포함하지 않는다
        dfs(idx + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);

        // S == 0 이면 공집합(아무것도 선택 안 함)도 sum==0으로 1번 카운트되므로 제거
        if (S == 0) count--;
        System.out.println(count);
    }
}
