package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 집의 수
        int[] snow = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
            total += snow[i];
            max = Math.max(max, snow[i]);
        }

        int result;
        if (max * 2 > total) {
            result = max;
        } else {
            result = (total + 1) / 2;
        }

        System.out.println(result > 1440 ? -1 : result);
    }
}
