package solved.bronze.B2;

import java.io.*;
import java.util.StringTokenizer;

public class B2_25576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //랄파 시청자 수 입력
        st = new StringTokenizer(br.readLine());
        int[] ralpha = new int[M];
        for(int i = 0; i < M; i++)
            ralpha[i] = Integer.parseInt(st.nextToken());

        //다른 스트리머에서 랄파와의 관계 계산
        int competitor = 0;
        int temp_viewer = 0;
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                temp_viewer += Math.abs(Integer.parseInt(st.nextToken()) - ralpha[j]);
            if(temp_viewer > 2000) // 딱 2000명인 경우엔 사이가 좋다고 본다. 처음에 이를 모르고 여기에 등호를 넣었다.
                competitor++;
            temp_viewer = 0; // 재사용하기 위해 0으로 초기화
        }

        int subscribe_count = N - 1;
        if(subscribe_count % 2 != 0) // 홀수명인 경우에 2로 나누면 절반에 미치지 못한 값이 나옴을 고려
            subscribe_count = subscribe_count / 2 + 1;
        else
            subscribe_count /= 2;

        if(competitor >= subscribe_count)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
