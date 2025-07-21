package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_1145 {
    // 최대공약수(GCD)
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // 최소공배수(LCM)
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    // 3개 이상으로 나누어지는지 확인
    static boolean isDivisible(int x, int[] arr) {
        int count = 0;
        for (int v : arr) {
            if (x % v == 0) count++;
        }
        return count >= 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 최소 후보값 저장
        int ans = Integer.MAX_VALUE;

        // 3개 조합
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 5; j++) {
                for (int k = j+1; k < 5; k++) {
                    int l = lcm(lcm(arr[i], arr[j]), arr[k]);
                    if (isDivisible(l, arr)) ans = Math.min(ans, l);
                }
            }
        }
        // 4개 조합
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 5; j++) {
                for (int k = j+1; k < 5; k++) {
                    for (int m = k+1; m < 5; m++) {
                        int l = lcm(lcm(lcm(arr[i], arr[j]), arr[k]), arr[m]);
                        if (isDivisible(l, arr)) ans = Math.min(ans, l);
                    }
                }
            }
        }
        // 5개 조합 (전부)
        int l = lcm(lcm(lcm(lcm(arr[0], arr[1]), arr[2]), arr[3]), arr[4]);
        if (isDivisible(l, arr)) ans = Math.min(ans, l);

        System.out.println(ans);
    }
}
