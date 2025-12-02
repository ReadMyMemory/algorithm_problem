package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aCount = Integer.parseInt(st.nextToken());
        int bCount = Integer.parseInt(st.nextToken());

        // A 집합
        Set<Integer> A = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aCount; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        // B 집합
        Set<Integer> B = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bCount; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        // 대칭 차집합: (A - B) ∪ (B - A)
        int answer = 0;

        for (int x : A) {
            if (!B.contains(x)) {
                answer++;
            }
        }

        for (int x : B) {
            if (!A.contains(x)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
