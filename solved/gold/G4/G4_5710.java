package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_5710 {

    // 사용량(Wh) -> 요금(원)
    private static int usageToBill(int wh) {
        int cost = 0;

        if (wh <= 100) {
            return wh * 2;
        }
        wh -= 100;
        cost += 100 * 2; // 200

        if (wh <= 9900) {
            cost += wh * 3;
            return cost;
        }
        wh -= 9900;
        cost += 9900 * 3; // 29,700

        if (wh <= 990000) {
            cost += wh * 5;
            return cost;
        }
        wh -= 990000;
        cost += 990000 * 5; // 4,950,000

        // 나머지
        cost += wh * 7;
        return cost;
    }

    // 요금(원) -> 사용량(Wh)
    private static int billToUsage(int money) {
        int wh = 0;

        if (money <= 200) {
            return money / 2;
        }
        money -= 200;
        wh += 100;

        if (money <= 29700) {
            wh += money / 3;
            return wh;
        }
        money -= 29700;
        wh += 9900;

        if (money <= 4950000) {
            wh += money / 5;
            return wh;
        }
        money -= 4950000;
        wh += 990000;

        // 나머지
        wh += money / 7;
        return wh;
    }

    private static int getSangBill(int A, int B) {
        int totalUsage = billToUsage(A);

        // 2. 상근이 사용량 이분 탐색 (0 ~ totalUsage / 2)
        int low = 0;
        int high = totalUsage / 2;
        int sangUsage = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            int sangCost = usageToBill(mid);
            int neighborCost = usageToBill(totalUsage - mid);
            int diff = neighborCost - sangCost;

            if (diff == B) {
                sangUsage = mid;
                break;
            }

            if (diff > B) {
                // 차이가 너무 큼 -> 상근이 사용량을 늘려서 차이를 줄이기
                low = mid + 1;
            } else {
                // 차이가 너무 작음 -> 상근이 사용량을 줄이기
                high = mid - 1;
            }
        }
        int sangBill = usageToBill(sangUsage);
        return sangBill;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) {
                break;
            }

            // 1. 총 사용량 구하기
            int sangBill = getSangBill(A, B);
            sb.append(sangBill).append('\n');
        }
        System.out.print(sb.toString());
    }
}
