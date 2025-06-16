package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 필요한 줄 개수
        int M = Integer.parseInt(st.nextToken()); // 브랜드 개수

        int minPack = Integer.MAX_VALUE; // 최소 패키지 가격
        int minPiece = Integer.MAX_VALUE; // 최소 낱개 가격

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int piece = Integer.parseInt(st.nextToken());
            minPack = Math.min(minPack, pack);
            minPiece = Math.min(minPiece, piece);
        }

        // 1. 모두 낱개로 살 경우
        int ans = minPiece * N;

        // 2. 패키지와 낱개 섞어서 사는 경우
        int packCount = N / 6;
        int remain = N % 6;
        int mixed = (packCount * minPack) + (remain * minPiece);
        ans = Math.min(ans, mixed);

        // 3. 패키지로만(넘치게) 사는 경우
        int onlyPack = ((N + 5) / 6) * minPack;
        ans = Math.min(ans, onlyPack);

        System.out.println(ans);
    }
}
