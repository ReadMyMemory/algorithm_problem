package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

/*
2차원 배열을 다음과 같이 향상된 for문으로 출력 가능하다.
for(int[] row : arr) {
for (int element : row) {
System.out.print(element+" ");
}
System.out.println();
}
 */

public class B3_2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int temp = 2;
        while(temp --> 0) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] += Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int[] row : arr) {
            for (int e : row) {
                bw.write(e + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
