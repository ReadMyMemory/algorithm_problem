package solved.silver.S3;
import java.io.*;

public class S3_3182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1]; // 1-indexed

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int maxCount = 0;

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            int count = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                count++;
                curr = arr[curr];
            }
            if (count > maxCount) {
                maxCount = count;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
