package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_31800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] profit = new int[N];
        int[] price  = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            profit[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 큰 이익(max1), 두 번째로 큰 이익(max2), max1의 개수(countMax1) 구하기
        int max1 = 0, max2 = 0, countMax1 = 0;
        for (int x : profit) {
            if (x > max1) {
                max2 = max1;
                max1 = x;
                countMax1 = 1;
            } else if (x == max1) {
                countMax1++;
            } else if (x > max2) {
                max2 = x;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // 자신을 제외한 최대 이익(otherMax)을 결정
            int otherMax = (profit[i] == max1 && countMax1 == 1) ? max2 : max1;
            // 기회비용 = otherMax - price[i]
            int opportunityCost = otherMax - price[i];
            // 순수익 = profit[i] - opportunityCost - price[i]
            int pure = profit[i] - opportunityCost - price[i];

            sb.append(pure);
            if (i < N - 1) sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}
