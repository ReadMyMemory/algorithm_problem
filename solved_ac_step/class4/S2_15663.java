package solved_ac_step.class4;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_15663 {
    static BufferedWriter bw;
    static int N, M;
    static int[] arr;
    static int[] print;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int idx = 0;
        while(idx != N)
            arr[idx++] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        visited = new boolean[N];
        print = new int[M];
        backTracking(0);
        bw.flush();
        br.close();
        bw.close();
    }
    private static void backTracking(int depth) throws IOException {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                bw.write(print[i]+" ");
            }
            bw.write("\n");
        } else {
            int before = 0; // before을 사용함으로써, 중복된 수열의 조합을 이루지 않도록 방지한다.
            for(int i = 0; i < N; i++) {
                // 예를 들어 현재 depth가 1이였고, 1 9 9 의 수열을 만들기 위함이라고 치면,
                // before에 9를 기억해놓으면, depth가 1인 자리에는 다른 9가 오지 못한다. 오직 처음 나온 9만 들어갈 수 있다.
                if(!visited[i] && before != arr[i]) {
                    visited[i] = true;
                    print[depth] = arr[i];
                    before = arr[i];
                    backTracking(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
