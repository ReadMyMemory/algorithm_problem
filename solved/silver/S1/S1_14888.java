package solved.silver.S1;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nums;
    static int[] op = new int[4]; // +, -, *, /
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0], op[0], op[1], op[2], op[3]);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    static void dfs(int idx, int current, int add, int sub, int mul, int div) {
        if (idx == n) {
            maxVal = Math.max(maxVal, current);
            minVal = Math.min(minVal, current);
            return;
        }

        int next = nums[idx];

        if (add > 0)
            dfs(idx + 1, current + next, add - 1, sub, mul, div);
        if (sub > 0)
            dfs(idx + 1, current - next, add, sub - 1, mul, div);
        if (mul > 0)
            dfs(idx + 1, current * next, add, sub, mul - 1, div);
        if (div > 0) {
            //음수를 양수로 나눌 때는 C++14처럼 0을 향해 버림
            int result;
            if (current < 0)
                result = - (Math.abs(current) / next);
            else
                result = current / next;

            dfs(idx + 1, result, add, sub, mul, div - 1);
        }
    }
}
