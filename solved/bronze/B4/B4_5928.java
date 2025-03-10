package solved.bronze.B4;
import java.io.*;
import java.util.*;

public class B4_5928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 시작 시간: 11일 11시 11분
        int startDay = 11, startHour = 11, startMinute = 11;

        // 입력된 종료 시간까지의 총 분 계산
        int startTotalMinutes = (startDay * 24 * 60) + (startHour * 60) + startMinute;
        int endTotalMinutes = (D * 24 * 60) + (H * 60) + M;

        // 종료 시간이 시작 시간보다 이전이면 -1 출력
        if (endTotalMinutes < startTotalMinutes) {
            System.out.println(-1);
        } else {
            System.out.println(endTotalMinutes - startTotalMinutes);
        }
    }
}
