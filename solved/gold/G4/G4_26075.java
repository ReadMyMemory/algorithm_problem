package solved.gold.G4;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class G4_26075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String S = br.readLine().trim();
        String T = br.readLine().trim();

        int L = N + M; // 길이
        // '1'의 위치를 1-indexed로 수집
        int[] posS = new int[M];
        int[] posT = new int[M];
        int idxS = 0, idxT = 0;

        for (int i = 0; i < L; i++) {
            if (S.charAt(i) == '1') posS[idxS++] = i + 1;
        }
        for (int i = 0; i < L; i++) {
            if (T.charAt(i) == '1') posT[idxT++] = i + 1;
        }

        long C = 0L;
        for (int i = 0; i < M; i++) {
            C += Math.abs((long)posS[i] - (long)posT[i]);
        }

        // 최소 비용 = ceil(C^2 / 2)
        BigInteger c = BigInteger.valueOf(C);
        BigInteger ans = c.multiply(c).add(BigInteger.ONE).divide(BigInteger.TWO);

        System.out.println(ans.toString());
    }
}
