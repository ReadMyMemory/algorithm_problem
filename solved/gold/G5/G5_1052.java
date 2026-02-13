package solved.gold.G5;
import java.io.*;
import java.util.*;

// 이진수에서 1의 개수로 풀기
public class G5_1052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        if (K >= Long.bitCount(N)) {
            System.out.println(0);
            return;
        }

        long bought = 0;

        while (Long.bitCount(N) > K) {
            long lsb = N & -N;   // 가장 낮은 1비트 값 (예: 12(1100) -> 4)
            bought += lsb;       // 그만큼 1리터 병을 산다고 생각하면 됨
            N += lsb;            // 올림(carry) 유도해서 1의 개수를 줄임
        }

        System.out.println(bought);
    }
}
