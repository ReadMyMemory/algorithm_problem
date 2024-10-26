package solved_ac_step.backtracking;
import java.io.*;
import java.util.StringTokenizer;

public class S3_15652 {
    static int M, N;
    static BufferedWriter bw;
    static int[] print;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        print = new int[M+1];
        visited = new boolean[M+1][N+1];

        backtracking(1, 1);
        bw.flush();
        br.close();
        bw.close();
    }
    private static void backtracking(int depth, int min) throws IOException {
        if(depth == M + 1) {
            for(int i = 1; i <= M; i++) {
                bw.write(print[i]+" ");
            }
            bw.write("\n");
        } else {
            for(int i = 1; i <= N; i++) {
                if(!visited[depth][i] && i >= min) {
                    visited[depth][i] = true;
                    print[depth] = i;
                    backtracking(depth + 1, i);
                    visited[depth][i] = false;
                }
            }
        }
    }
}
