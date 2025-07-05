package solved.silver.S5;
import java.io.*;

public class S5_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;

        while (X > 0) {
            // X의 이진수에서 1의 개수 세기 (X & 1이 1이면 count 증가)
            if ((X & 1) == 1) count++;
            X = X >> 1; // X를 오른쪽으로 한 칸 shift (2로 나눈 효과)
        }
        System.out.println(count);
    }
}
