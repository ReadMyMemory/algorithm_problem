package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_6236 {

    /*
     * 아이디어
     * 1. K원을 출금했을 때 M번 이하로 생활 가능한지 확인한다.
     * 2. 가능하면 더 작은 K도 되는지 확인하고,
     *    불가능하면 더 큰 K를 찾아야 한다.
     * 3. 따라서 K에 대해 이분 탐색을 수행한다.
     */

    static int N, M;
    static int[] money;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];

        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, money[i]); // 최소 K는 하루 최대 지출 이상이어야 함
            right += money[i];               // 최대 K는 전체 합
        }

        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canLive(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    static boolean canLive(int k) {
        int count = 1;   // 처음 한 번 출금
        int remain = k;

        for (int i = 0; i < N; i++) {
            if (remain < money[i]) {
                count++;
                remain = k;
            }
            remain -= money[i];
        }
        return count <= M;
    }
}
