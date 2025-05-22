package solved.silver.S5;
import java.io.*;

/*
7이상은 무조건 3
그 이하는 개미수열 직접 계산
*/

public class S5_28292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N >= 7) {
            System.out.println(3);
            return;
        }

        StringBuilder cur = new StringBuilder("1");
        for (int i = 1; i < N; i++) {
            StringBuilder next = new StringBuilder();
            int len = cur.length();
            int cnt = 1;
            for (int j = 1; j < len; j++) {
                if (cur.charAt(j) == cur.charAt(j - 1)) cnt++;
                else {
                    next.append(cur.charAt(j - 1));
                    next.append(cnt);
                    cnt = 1;
                }
            }
            next.append(cur.charAt(len - 1));
            next.append(cnt);
            cur = next;
        }
        int max = 0;
        for (int i = 0; i < cur.length(); i++) {
            int digit = cur.charAt(i) - '0';
            if (digit > max) max = digit;
        }
        System.out.println(max);
    }
}
