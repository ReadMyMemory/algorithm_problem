package Arena.season16;
import java.io.*;
import java.util.StringTokenizer;

public class A2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //트랙의 수 N
        int K = Integer.parseInt(st.nextToken()); //트랙을 늘릴 수 있는 길이 K
        int[] track = new int[N];
        boolean[] stats = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            track[i] = Integer.parseInt(st.nextToken());
        }
        boolean status = true;
        int count = 0;
//        if(N == 1) status = false; 진짜 조건 애매모호한게 정말 싫다. 1은 걍 0 출력 하면 되는거였다.
        if(N == 2) {
            if(track[0] >= track[1]) {
                count++;
                track[1] += K;
                if(track[0] >= track[1])
                    status = false;
            }
        }
        else {
            for (int i = 1; i < N - 1; i++) {
                if (track[i - 1] >= track[i]) {
                    if(!stats[i]) { // 이미 트랙의 길이 더했는지 체크
                        count++;
                        track[i] += K;
                        stats[i] = true;
                    }
                    if (track[i - 1] >= track[i]) {
                        status = false;
                        break;
                    }
                }
                if (track[i] >= track[i + 1]) {
                    count++;
                    track[i + 1] += K;
                    stats[i + 1] = true;
                    if (track[i] >= track[i + 1]) {
                        status = false;
                        break;
                    }
                }
            }
        }
        if(status)
            System.out.println(count);
        else
            System.out.println(-1);
    }
}
