package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_5911 {
    static class Friend implements Comparable<Friend> {
        long price, ship;
        public Friend(long price, long ship) {
            this.price = price;
            this.ship = ship;
        }
        public long totalCost() {
            return price + ship;
        }
        // 배송비 포함 오름차순 정렬
        public int compareTo(Friend o) {
            return Long.compare(this.totalCost(), o.totalCost());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Friend[] friends = new Friend[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long price = Long.parseLong(st.nextToken());
            long ship = Long.parseLong(st.nextToken());
            friends[i] = new Friend(price, ship);
        }

        int answer = 0;
        for (int couponIdx = 0; couponIdx < N; couponIdx++) {
            long couponCost = (friends[couponIdx].price / 2) + friends[couponIdx].ship;
            List<Long> otherCosts = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (i == couponIdx) continue;
                otherCosts.add(friends[i].totalCost());
            }
            Collections.sort(otherCosts);

            int cnt = 1; // 쿠폰 쓴 친구
            long sum = couponCost;
            for (long c : otherCosts) {
                if (sum + c > B) break;
                sum += c;
                cnt++;
            }
            if (sum <= B) answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
