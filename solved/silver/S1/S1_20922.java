package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 숫자의 개수를 저장하는 배열 (1 <= a_i <= 100,000)
        int[] count = new int[100001];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < N; right++) {
            // right 포인터가 가리키는 숫자의 개수 증가
            count[arr[right]]++;

            // 현재 추가한 숫자의 개수가 K를 초과하면 left를 이동
            while (count[arr[right]] > K) {
                count[arr[left]]--;
                left++;
            }
            // 현재 윈도우의 길이로 최대 길이 갱신
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }
}