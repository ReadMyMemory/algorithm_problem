package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];
            int sum = 0;

            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }

            double avg = (double) sum / N;
            int count = 0;
            for (int score : scores) {
                if (score > avg) {
                    count++;
                }
            }
            double percent = (double) count / N * 100;
            System.out.printf("%.3f%%\n", percent);
        }
    }
}
