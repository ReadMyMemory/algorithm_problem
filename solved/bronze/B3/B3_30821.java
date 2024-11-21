package solved.bronze.B3;
import java.io.*;

/*
별을 만들기 위해 선택하는 점은 5개.
선택된 점은 구별을 하지 않으므로 Combination을 써야 할 듯.
100이라면
이항 계수 공식을 활용하여
100! / 5! * 95! 이다.
즉 100 * 99 * 98 * 97 * 96 / 5!임.
 */

public class B3_30821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(N * (N-1) * (N-2) * (N-3) * (N-4) / 120);
    }
}
