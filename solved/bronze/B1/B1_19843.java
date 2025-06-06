package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_19843 {
    static Map<String, Integer> dayMap = new HashMap<>();
    static {
        dayMap.put("Mon", 0);
        dayMap.put("Tue", 1);
        dayMap.put("Wed", 2);
        dayMap.put("Thu", 3);
        dayMap.put("Fri", 4);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());  // 일주일에 자야할 시간
        int N = Integer.parseInt(st.nextToken());  // 평일 동안 잠든 횟수

        int totalSleep = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String D1 = st.nextToken();
            int H1 = Integer.parseInt(st.nextToken());
            String D2 = st.nextToken();
            int H2 = Integer.parseInt(st.nextToken());

            // 시각을 월요일 0시 기준의 시간으로 변환
            int start = dayMap.get(D1) * 24 + H1;
            int end = dayMap.get(D2) * 24 + H2;

            totalSleep += (end - start);
        }

        int remain = T - totalSleep;
        if (remain <= 0) {
            System.out.println(0);
        } else if (remain > 48) {
            System.out.println(-1);
        } else {
            System.out.println(remain);
        }
    }
}
