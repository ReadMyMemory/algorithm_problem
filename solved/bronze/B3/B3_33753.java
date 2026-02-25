package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_33753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력이 한 줄이든 여러 줄이든 숫자 4개를 모두 모아서 처리
        List<Long> nums = new ArrayList<>(4);
        String line;
        while (nums.size() < 4 && (line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens() && nums.size() < 4) {
                nums.add(Long.parseLong(st.nextToken()));
            }
        }

        long A = nums.get(0);
        long B = nums.get(1);
        long C = nums.get(2);
        long T = nums.get(3);

        long ans;
        if (T <= 30) {
            ans = A;
        } else {
            long extra = T - 30;
            long units = (extra + B - 1) / B; // 올림
            ans = A + units * C;
        }
        System.out.println(ans);
    }
}