package solved.silver.S2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 노드의 개수 입력
        int n = Integer.parseInt(br.readLine());
        
        // 관계 행렬 입력받기
        char[][] graph = new char[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = st.nextToken().charAt(0);
            }
        }
        
        // 질의 개수 입력
        int m = Integer.parseInt(br.readLine());
        
        // 각 질의에 대해 처리
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            // B와 C의 관계 출력
            sb.append(graph[b][c]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
