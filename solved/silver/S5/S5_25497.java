package solved.silver.S5;
import java.io.*;

public class S5_25497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String skills = br.readLine().trim();

        int availableL = 0, availableS = 0;
        int successCount = 0;
        boolean broken = false;

        for (int i = 0; i < skills.length() && !broken; i++) {
            char c = skills.charAt(i);
            if (c >= '1' && c <= '9') {
                // 독립 기술은 언제나 성공
                successCount++;
            } else if (c == 'L') {
                // L은 R의 사전 기술
                availableL++;
            } else if (c == 'S') {
                // S는 K의 사전 기술
                availableS++;
            } else if (c == 'R') {
                // R은 L과 연계
                if (availableL > 0) {
                    availableL--;
                    successCount++;
                } else {
                    // 사전 기술 없이 본 기술 사용 → 스크립트 붕괴
                    broken = true;
                }
            } else if (c == 'K') {
                // K는 S와 연계
                if (availableS > 0) {
                    availableS--;
                    successCount++;
                } else {
                    // 사전 기술 없이 본 기술 사용 → 스크립트 붕괴
                    broken = true;
                }
            }
        }
        System.out.println(successCount);
    }

}
