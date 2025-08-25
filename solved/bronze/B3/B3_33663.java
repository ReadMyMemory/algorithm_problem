package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_33663 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h_lo = Integer.parseInt(st.nextToken());
        int h_hi = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s_lo = Integer.parseInt(st.nextToken());
        int s_hi = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int v_lo = Integer.parseInt(st.nextToken());
        int v_hi = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // RGB to HSV 변환
        int M = Math.max(R, Math.max(G, B));  // 최댓값
        int m = Math.min(R, Math.min(G, B));  // 최솟값

        // V 계산
        double V = M;

        // S 계산
        double S = 255.0 * (V - m) / V;

        // H 계산
        double H = 0;
        if (M == R) {
            H = 60.0 * (G - B) / (V - m);
        } else if (M == G) {
            H = 120 + 60.0 * (B - R) / (V - m);
        } else if (M == B) {
            H = 240 + 60.0 * (R - G) / (V - m);
        }

        // H가 0 미만일 경우 360 더하기
        if (H < 0) {
            H += 360;
        }

        // 범위 확인
        boolean isValidH = (H >= h_lo && H <= h_hi);
        boolean isValidS = (S >= s_lo && S <= s_hi);
        boolean isValidV = (V >= v_lo && V <= v_hi);

        // 결과 출력
        if (isValidH && isValidS && isValidV) {
            System.out.println("Lumi will like it.");
        } else {
            System.out.println("Lumi will not like it.");
        }
    }
}