package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, L, H 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        // 점수 배열 입력 및 정렬
        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(scores);
        
        // L개의 최저점과 H개의 최고점을 제외한 점수들의 합 계산
        double sum = 0;
        int count = 0;
        
        // L번째 인덱스부터 N-H-1번째 인덱스까지의 합 구하기
        for (int i = L; i < N - H; i++) {
            sum += scores[i];
            count++;
        }
        
        // 평균 계산 및 출력
        double average = sum / count;
        System.out.println(average);
    }
}
