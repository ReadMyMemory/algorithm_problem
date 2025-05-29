package solved.bronze.B1;
import java.io.*;

public class B1_25183 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < N; i++) {
            char prev = S.charAt(i - 1);
            char curr = S.charAt(i);

            // 사전상 이웃 확인 (ASCII 차이 1)
            if (Math.abs(prev - curr) == 1) {
                curLen++;
                if (curLen >= 5) {
                    System.out.println("YES");
                    return;
                }
            } else {
                curLen = 1;
            }
        }

        System.out.println("NO");
    }
}
