package solved.silver.S3;
import java.io.*;

public class S3_1740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        long n = Long.parseLong(br.readLine());

        // N번째 수 계산
        long result = 0;
        long power = 1; // 3^0 = 1

        // N을 이진수로 생각하고, 각 비트 위치에 대응하는 3의 제곱수를 더함
        while (n > 0) {
            if ((n & 1) == 1) { // 최하위 비트가 1이면
                result += power; // 해당 3의 제곱수를 더함
            }
            power *= 3; // 다음 3의 제곱수
            n >>= 1; // N을 오른쪽으로 1비트 시프트
        }
        System.out.println(result);
    }
}