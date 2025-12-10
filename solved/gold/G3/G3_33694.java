package solved.gold.G3;
import java.io.*;
import java.util.*;

public class G3_33694 {

    private static class Event {
        long time;
        int delta;
        Event(long time, int delta) {
            this.time = time;
            this.delta = delta;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        // 최대 2 * N 개 이벤트
        Event[] tmp = new Event[2 * N];
        int m = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            long T = Long.parseLong(st.nextToken());

            // 증가 구간에서 C 이상이 되는 최소 날 (소환일로부터의 오프셋)
            long kg = (C + A - 1) / A;   // ceil(C / A)
            long S0 = kg * A;           // 최대 크기

            // 최대 크기가 X보다 작으면 이 슬라임은 X 이상이 될 일이 없음
            if (S0 < X) continue;

            // X 이상이 되는 첫 날
            long firstOffset = (X + A - 1) / A; // ceil(X / A)
            long L = T + firstOffset;

            // X 이상인 마지막 날 (감소 구간에서)
            long jStar = (S0 - X) / B;
            long R = T + kg + jStar;

            if (L > R) continue; // 안전용; 실제로는 나올 일이 거의 없음

            tmp[m++] = new Event(L, 1);      // [L, R+1) 시작
            tmp[m++] = new Event(R + 1, -1); // 끝 다음 날
        }

        if (m == 0) {
            System.out.println(0);
            return;
        }

        Event[] events = Arrays.copyOf(tmp, m);
        Arrays.sort(events, (e1, e2) -> Long.compare(e1.time, e2.time));

        long answer = 0L;
        long currCount = 0L;
        long prevTime = events[0].time;

        int idx = 0;
        while (idx < m) {
            long t = events[idx].time;

            // prevTime ~ t 구간 동안의 카운트가 동일
            if (t > prevTime) {
                if (currCount >= 3) {
                    answer += (t - prevTime);
                }
                prevTime = t;
            }

            // 같은 시점의 이벤트들을 모두 반영
            while (idx < m && events[idx].time == t) {
                currCount += events[idx].delta;
                idx++;
            }
        }
        System.out.println(answer);
    }
}
