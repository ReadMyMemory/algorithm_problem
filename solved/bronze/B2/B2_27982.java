package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_27982 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][][] space = new boolean[N+2][N+2][N+2]; // N + 2로 사이즈 잡은 이유는 입체 공간을 벗어난 탐색 때문에 ArrayIndexOutofBoundsException을 방지하기 위함이다.
        int idx = M;
        while(idx --> 0) {
            st = new StringTokenizer(br.readLine());
            space[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }
        System.out.println(solution(N, M, space));
    }
    private static int solution(int N, int M, boolean[][][] space) {
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int w = 1; w <= N; w++) {
                    if(space[i][j][w]) {
                        if(space[i + 1][j][w] && space[i - 1][j][w] && space[i][j + 1][w] && space[i][j - 1][w] && space[i][j][w + 1] && space[i][j][w - 1])
                            answer++;
                    }
                }
            }
        }
        return answer;
    }
}
