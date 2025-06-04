package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_10448 {
    public static void main(String[] args) throws IOException {
        // 입력 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 1000 이하의 삼각수 리스트 만들기
        ArrayList<Integer> triangles = new ArrayList<>();
        for (int n = 1; ; n++) {
            int t = n * (n + 1) / 2;
            if (t > 1000) break;
            triangles.add(t);
        }
        int size = triangles.size();

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());
            boolean found = false;

            // 3중 for문: 순서 상관없이 3개 고르기(중복 가능)
            outer:
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        if (triangles.get(i) + triangles.get(j) + triangles.get(k) == K) {
                            found = true;
                            break outer;
                        }
                    }
                }
            }
            sb.append(found ? "1" : "0").append("\n");
        }
        System.out.print(sb);
    }
}

