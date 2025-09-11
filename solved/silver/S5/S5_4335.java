package solved.silver.S5;
import java.io.*;

public class S5_4335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("0")) break;

            int low = 1;   // 가능한 최소값
            int high = 10; // 가능한 최대값
            boolean dishonest = false;

            while (true) {
                int guess = Integer.parseInt(line);
                String response = br.readLine();

                if (response.equals("right on")) {
                    // 최종 답이 가능한 범위 내에 있는지 확인
                    if (guess < low || guess > high) {
                        dishonest = true;
                    }
                    break;
                } else if (response.equals("too high")) {
                    // 올리가 말한 수보다 작아야 함
                    high = Math.min(high, guess - 1);
                } else if (response.equals("too low")) {
                    // 올리가 말한 수보다 커야 함
                    low = Math.max(low, guess + 1);
                }

                // 가능한 범위가 없으면 거짓말
                if (low > high) {
                    dishonest = true;
                }

                line = br.readLine();
            }

            if (dishonest) {
                System.out.println("Stan is dishonest");
            } else {
                System.out.println("Stan may be honest");
            }
        }
    }
}