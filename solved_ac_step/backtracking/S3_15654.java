package solved_ac_step.backtracking;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_15654 {
    static int N_size;
    static int[] N;
    static int M;
    static int[] print;
    static BufferedWriter bw;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //입력부
        st = new StringTokenizer(br.readLine());
        N_size = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        N = new int[N_size + 1];
        print = new int[M+1];
        visited = new boolean[10001];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N_size; i++)
            N[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(N);

        backtracking(1);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backtracking(int depth) throws IOException {
        if(depth == M + 1) {
            for(int i = 1; i <= M; i++) {
                bw.write(print[i]+" ");
            }
            bw.write("\n");
        } else {
            for(int i = 1; i <= N_size; i++) {
                if(!visited[N[i]]) {
                    visited[N[i]] = true;
                    print[depth] = N[i];
                    backtracking(depth + 1);
                    visited[N[i]] = false;
                }
            }
        }
    }
}
