package solved.bronze.B1;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1_31823 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>(); // 서로 다른 스트릭 값의 개수를 출력하기 위해 중복 값을 허용하지 않는 set 사용

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int max = 0;
            int now_max = 0;
            for(int j = 0; j < M; j++) {
                String s = st.nextToken();
                if(s.equals("*")) {
                    if(now_max == 0)
                        continue;
                    else {
                        max = Math.max(max, now_max);
                        now_max = 0;
                    }
                } else {
                    now_max++;
                }
                if(j == M-1) // 마지막일 때 최장 리버스 - 스트릭 계산
                    max = Math.max(max, now_max);
            }
            set.add(max);
            bw.write(max+" ");
            bw.write(st.nextToken() + "\n");
        }
        System.out.println(set.size());
        bw.flush();
        br.close();
        bw.close();
    }
}
