package solved.gold.G3;
import java.io.*;

public class G3_25921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        long totalCost = 0;
        
        // 각 소수 p에 대해:
        // - p는 1과 연결 (비용 p)
        // - p의 배수들은 p와 연결 (각각 비용 p)
        
        boolean[] used = new boolean[N + 1];
        
        for (int p = 2; p <= N; p++) {
            if (!used[p]) { // p가 아직 처리 안됨 = p가 소수
                // p와 1 연결
                totalCost += p;
                used[p] = true;
                
                // p의 배수들을 p와 연결
                for (int mult = p + p; mult <= N; mult += p) {
                    if (!used[mult]) {
                        totalCost += p;
                        used[mult] = true;
                    }
                }
            }
        }
        System.out.println(totalCost);
    }
}
