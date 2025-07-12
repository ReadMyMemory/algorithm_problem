package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_3005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] map = new String[R];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine();
        }

        ArrayList<String> words = new ArrayList<>();

        // 가로 단어 찾기
        for (int i = 0; i < R; i++) {
            String[] arr = map[i].split("#");
            for (String s : arr) {
                if (s.length() >= 2) words.add(s);
            }
        }

        // 세로 단어 찾기
        for (int c = 0; c < C; c++) {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < R; r++) {
                sb.append(map[r].charAt(c));
            }
            String[] arr = sb.toString().split("#");
            for (String s : arr) {
                if (s.length() >= 2) words.add(s);
            }
        }

        Collections.sort(words); // 사전순 정렬
        System.out.println(words.get(0)); // 가장 앞선 단어 출력
    }
}
