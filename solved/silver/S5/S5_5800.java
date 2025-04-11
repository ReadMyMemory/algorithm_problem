package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int classNum = 1; classNum <= K; classNum++) {
            String[] tokens = br.readLine().split(" ");
            int N = Integer.parseInt(tokens[0]);

            Integer[] scores = new Integer[N];
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(tokens[i + 1]);
            }

            // 내림차순 정렬
            Arrays.sort(scores, Collections.reverseOrder());

            int max = scores[0];
            int min = scores[N - 1];
            int largestGap = 0;

            // 인접한 점수 차이 중 최대값 계산
            for (int i = 0; i < N - 1; i++) {
                int gap = scores[i] - scores[i + 1];
                if (gap > largestGap) {
                    largestGap = gap;
                }
            }

            // 출력
            System.out.println("Class " + classNum);
            System.out.println("Max " + max + ", Min " + min + ", Largest gap " + largestGap);
        }
    }
}
