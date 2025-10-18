package solved.bronze.B4;
import java.io.*;

public class B4_31867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String K = br.readLine();

        int evenCount = 0;  // 짝수 개수
        int oddCount = 0;   // 홀수 개수

        // 각 자릿수 확인
        for (int i = 0; i < N; i++) {
            int digit = K.charAt(i) - '0';

            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // 결과 판별
        if (evenCount > oddCount) {
            System.out.println(0);  // 짝짝수
        } else if (oddCount > evenCount) {
            System.out.println(1);  // 홀홀수
        } else {
            System.out.println(-1); // 같음
        }
    }
}