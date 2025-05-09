package solved.silver.S3;
import java.io.*;
import java.util.Arrays;

public class S3_1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빨대 개수 읽기
        int N = Integer.parseInt(br.readLine());
        int[] straw = new int[N];

        // 각 빨대 길이 읽기
        for (int i = 0; i < N; i++) {
            straw[i] = Integer.parseInt(br.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(straw);

        long maxPerimeter = -1;
        // 가장 긴 쪽부터 내려오며, 세 변이 삼각형 조건을 만족하는지 확인
        for (int i = N - 1; i >= 2; i--) {
            long a = straw[i];
            long b = straw[i - 1];
            long c = straw[i - 2];
            // 긴 변 a < 다른 두 변의 합
            if (b + c > a) {
                maxPerimeter = a + b + c;
                break;
            }
        }

        // 결과 출력
        System.out.println(maxPerimeter);
    }
}
