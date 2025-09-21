package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에서 n 입력
        int n = Integer.parseInt(br.readLine());

        // 둘째 줄에서 n개의 정수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // maxEndingHere: 현재 위치에서 끝나는 최대 부분 수열의 합
        // maxSoFar: 지금까지 발견한 최대 부분 수열의 합
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            // 현재 원소를 포함하여 이전까지의 합을 이어갈지,
            // 아니면 현재 원소부터 새로 시작할지 결정
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // 전체 최댓값 갱신
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        System.out.println(maxSoFar);
    }
}