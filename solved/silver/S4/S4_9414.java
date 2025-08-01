package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_9414 {
    static final long MAX = 5000000L; // 억 단위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            List<Integer> lands = new ArrayList<>();
            while (true) {
                int price = Integer.parseInt(br.readLine().trim());
                if (price == 0) break;
                lands.add(price);
            }
            // 내림차순(가장 비싼 것 먼저)
            lands.sort(Collections.reverseOrder());

            long sum = 0;
            boolean tooExpensive = false;
            for (int i = 0; i < lands.size(); i++) {
                long p = lands.get(i);
                long pow = 1;
                for (int j = 0; j < i + 1; j++) {
                    pow *= p;
                    if (pow > MAX) {
                        pow = MAX + 1;
                        break;
                    }
                }
                long cost = 2 * pow;
                if (cost > MAX || sum > MAX - cost) {
                    tooExpensive = true;
                    break;
                }
                sum += cost;
            }
            if (tooExpensive) {
                System.out.println("Too expensive");
            } else {
                System.out.println(sum);
            }
        }
    }
}