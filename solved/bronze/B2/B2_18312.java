package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_18312 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char target = (char) ('0' + K);
        int count = 0;

        for (int h = 0; h <= N; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    // 2자리 문자열로 맞춘 뒤, K 포함 여부 확인
                    String time = two(h) + two(m) + two(s);
                    if (time.indexOf(target) != -1) count++;
                }
            }
        }
        System.out.println(count);
    }

    private static String two(int x) {
        return (x < 10) ? "0" + x : String.valueOf(x);
    }
}
