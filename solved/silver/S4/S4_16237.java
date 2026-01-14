package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_16237 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken()); // 1kg
        long B = Long.parseLong(st.nextToken()); // 2kg
        long C = Long.parseLong(st.nextToken()); // 3kg
        long D = Long.parseLong(st.nextToken()); // 4kg
        long E = Long.parseLong(st.nextToken()); // 5kg

        long ans = 0;

        // 5kg는 무조건 단독
        ans += E;

        // 4kg는 1kg와 페어(4+1) 가능하면 무조건 하는 게 최적
        ans += D;
        long use1 = Math.min(D, A);
        A -= use1;

        // 3kg는 2kg와 페어(3+2) 우선
        long pair32 = Math.min(C, B);
        ans += pair32;
        C -= pair32;
        B -= pair32;

        // 남은 3kg는 각각 바구니 1개, 1kg를 최대 2개까지 채움(3+1+1)
        ans += C;
        long useFor3 = Math.min(2 * C, A);
        A -= useFor3;
        C = 0;

        // 이제 2kg와 1kg만 남음
        // (2+2+1)부터 최대한 채우기
        long t = Math.min(B / 2, A);
        ans += t;
        B -= 2 * t;
        A -= t;

        // 남은 2kg 두 개씩은 (2+2)로 바구니 하나
        ans += B / 2;
        B %= 2;

        // 2kg 하나 남으면 1kg가 있든 없든 어차피 바구니 1개
        if (B == 1) {
            ans += 1;
            if (A >= 3) A -= 3; // (2+1+1+1) 가능하면 채움
            else A = 0;         // (2 + 남은 1들) 다 넣어도 어차피 한 바구니
        }

        // 남은 1kg는 5개씩
        ans += (A + 4) / 5;

        System.out.println(ans);
    }
}
