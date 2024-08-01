package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 운동 시간 N분
        int m = Integer.parseInt(st.nextToken()); // 영식이의 맥박 최소 임계치이자 영식이의 초기 맥박 m
        int M = Integer.parseInt(st.nextToken()); // 영식이의 맥박 최대 임계치 M
        int T = Integer.parseInt(st.nextToken()); // 영식이가 운동할 때 증가하는 맥박 증가치 T
        int R = Integer.parseInt(st.nextToken()); // 영식이가 휴식할 때 떨어지는 맥박 감소치 R

        if(m + T > M) // 최소치에서 운동을 하면 맥박 임계치를 넘어버리는 경우
            System.out.println(-1);
        else {
            int minute = 0;
            int now_m = m; // 실시간 맥박 수
            int now_N = 0; // 실시간 운동 수
            while(N != now_N) {
                if(now_m + T <= M) {
                    now_m += T; // 운동하기
                    minute++;
                    now_N++;
                }
                while(now_m > M) { // 운동 한번 했을 때 맥박 최대치를 넘어버린다면 운동을 하지 않고 휴식으로 맥박을 낮추기
                    now_m -= R;
                    minute++;
                }
                if(now_m < m) // 맥박은 최소치보다 낮아질 수 없다. 현재 맥박에 그보다 낮다면 최소치로 조정
                    now_m = m;
            }
            System.out.println(minute);
        }
    }
}
