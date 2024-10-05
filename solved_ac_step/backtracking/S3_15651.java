package solved_ac_step.backtracking;
import java.io.*;
import java.util.StringTokenizer;

public class S3_15651 {

    static int N;
    static int M;
    static int[] print;
    static BufferedWriter bw;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력부
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        print = new int[M+1];
        visited = new boolean[M+1][N+1];

        backtracking(1);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backtracking(int depth) throws IOException {
        if(depth == M + 1) {
            for(int i = 1; i <= M; i++)
                bw.write(String.valueOf(print[i])+" ");
            bw.write("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visited[depth][i]) {
                    visited[depth][i] = true;
                    print[depth] = i;
                    backtracking(depth + 1);
                    visited[depth][i] = false;
                }
            }
        }
    }
}
