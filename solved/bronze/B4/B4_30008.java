package solved.bronze.B4;
import java.io.*;
import java.util.*;

public class B4_30008 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 학생 수
    int K = Integer.parseInt(st.nextToken()); // 과목 수

    int[] grades = new int[K];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
        grades[i] = Integer.parseInt(st.nextToken());
    }

    int[] result = new int[K];
    for (int i = 0; i < K; i++) {
        int P = (grades[i] * 100) / N; // 백분율 계산
        result[i] = getGrade(P);
    }

    // 결과 출력
    StringBuilder sb = new StringBuilder();
    for (int grade : result) {
        sb.append(grade).append(" ");
    }
    System.out.println(sb.toString().trim());
}

    private static int getGrade(int P) {
        if (P <= 4) return 1;
        if (P <= 11) return 2;
        if (P <= 23) return 3;
        if (P <= 40) return 4;
        if (P <= 60) return 5;
        if (P <= 77) return 6;
        if (P <= 89) return 7;
        if (P <= 96) return 8;
        return 9;
    }
}
