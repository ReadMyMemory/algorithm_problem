package solved;

import java.io.*;
import java.util.StringTokenizer;

public class S3_15649 {
    static boolean[] visited;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N]; // 방문처리용 배열. 이미 선택한 숫자는 다시 선택 x
        arr = new int[M]; // 탐색한 거 기록용 배열
        dfs(N, M, 0);
    }

    public static void dfs(int n, int m, int depth) {
        if(depth == m) {
            for (int print : arr)
                System.out.print(print + " ");
            System.out.println("");
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth+1);
                visited[i] = false;
            }
        }



    }


}
