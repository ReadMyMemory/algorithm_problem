package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기 n 입력
        int n = Integer.parseInt(br.readLine());

        // 수열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // x 입력
        int x = Integer.parseInt(br.readLine());

        // 배열 정렬
        Arrays.sort(arr);

        // 투 포인터 알고리즘
        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                // 합이 x와 같으면 쌍을 찾은 것
                count++;
                left++;
                right--;
            } else if (sum < x) {
                // 합이 x보다 작으면 왼쪽 포인터를 오른쪽으로
                left++;
            } else {
                // 합이 x보다 크면 오른쪽 포인터를 왼쪽으로
                right--;
            }
        }
        System.out.println(count);
    }
}