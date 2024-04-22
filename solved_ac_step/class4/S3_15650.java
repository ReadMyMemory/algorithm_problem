package solved_ac_step.class4;
import java.io.*;
import java.util.StringTokenizer;

public class S3_15650 {
    static int[] arr;
    static int N, M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(1, 0);
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int at, int depth) throws IOException {
        if(depth == M) {
            for (int val : arr) {
                bw.write(String.valueOf(val));
                bw.write(" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
