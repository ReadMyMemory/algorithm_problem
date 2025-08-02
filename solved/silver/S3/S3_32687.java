package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_32687 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int answer = 0;

        // K자리 수 범위
        long start = (long)Math.pow(10, K - 1);
        long end = (long)Math.pow(10, K) - 1;

        for (long seed = start; seed <= end; seed++) {
            // 최대 몇 번까지 반복 가능한지 (길이 제한)
            int maxRepeat = 1;
            long t = seed;
            while (t <= B) {
                t = t * (long)Math.pow(10, K) + seed;
                maxRepeat++;
            }
            // minLength는 K, maxLength는 B길이
            for (int repeat = 1; repeat <= maxRepeat; repeat++) {
                // full number (seed를 repeat번 반복한 숫자)
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < repeat; i++) sb.append(seed);
                String fullNumStr = sb.toString();
                if (fullNumStr.length() < K) continue;
                // 뒤에서 0개~K-1개 잘라서, K자리 이상인 숫자 생성
                for (int cut = 0; cut < K; cut++) {
                    if (fullNumStr.length() - cut < K) break;
                    String candidateStr = fullNumStr.substring(0, fullNumStr.length() - cut);
                    long num = Long.parseLong(candidateStr);
                    if (num < A || num > B) continue;
                    if (num % M == 0) answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
