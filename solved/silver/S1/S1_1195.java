package solved.silver.S1;
import java.io.*;

public class S1_1195 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine().trim();
        String b = br.readLine().trim();

        int n = a.length();
        int m = b.length();

        int answer = n + m; // 최댓값(완전히 안 겹치게 놓는 경우)

        // shift: b의 시작 위치가 a의 0번 기준으로 이동한 칸 수
        // b가 완전히 a 왼쪽에 있을 수도 있으니 -m ~ n 까지 검사해야함
        for (int shift = -m; shift <= n; shift++) {
            int overlapStart = Math.max(0, shift);
            int overlapEnd = Math.min(n, shift + m);

            boolean ok = true;
            for (int pos = overlapStart; pos < overlapEnd; pos++) {
                char ca = a.charAt(pos);
                char cb = b.charAt(pos - shift);
                if (ca == '2' && cb == '2') {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                int left = Math.min(0, shift);
                int right = Math.max(n, shift + m);
                int len = right - left;
                if (len < answer) answer = len;
            }
        }
        System.out.println(answer);
    }
}
