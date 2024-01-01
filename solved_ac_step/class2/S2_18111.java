package solved_ac_step.class2;
import java.io.*;
import java.util.StringTokenizer;

public class S2_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        for(int h = 0; h <= 256; h++) { // 높이 0부터 256까지 최소 시간 찾기. 하나하나 비교
            int removeNum = 0;
            int buildNum = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    int height = map[i][j] - h; // 정해진 높이 h보다 낮은지 높은지를 판단하여 제거할지 쌓을지 결정
                    if(height > 0) removeNum += height;
                    else if(height < 0) buildNum -= height;
                }
            }
            //해당 높이를 맞추기 위해 제거해야 하는 블록 수 + 가진 블록 수가 지어야 하는 블록 수보다 많음?
            if(removeNum + B >= buildNum) {
                int time = removeNum * 2 + buildNum;
                if(minTime >= time) { // 여기서 등호를 해줘야 하는 이유는 시간이 같아도 높이가 높다면 높이가 높은걸 골라야 해서 꼭 maxHeight를 갱신해줘야 한다.
                    minTime = time;
                    maxHeight = h;
                }
            }
        }
        System.out.print(minTime + " " + maxHeight);
    }

}
