package solved.silver.bfs;
import java.io.*;
import java.util.StringTokenizer;

public class S3_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int computer = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        //서로가 연결되었음을 확인하는 것은 이차원 배열을 통해 기록한다.
        /*
        1 감염 시작...
        1 - 3
         */
        boolean[][] arr = new boolean[computer][computer];
        for(int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }

    }
}
