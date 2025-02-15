package solved.bronze.B2;

import java.io.*;
import java.util.*;

public class B2_1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 선수 수 입력
        int N = Integer.parseInt(br.readLine());

        // 첫 글자의 출현 빈도를 기록할 Map
        Map<Character, Integer> letterCount = new HashMap<>();

        // 선수 이름 입력 받고 첫 글자 빈도 세기
        for (int i = 0; i < N; i++) {
            String playerName = br.readLine();
            char firstLetter = playerName.charAt(0);
            letterCount.put(firstLetter, letterCount.getOrDefault(firstLetter, 0) + 1);
        }

        // 선발할 수 있는 첫 글자 찾기
        StringBuilder sb = new StringBuilder();
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (letterCount.getOrDefault(letter, 0) >= 5) {
                sb.append(letter);
            }
        }

        // 결과 출력
        if (sb.length() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("PREDAJA");
        }
    }
}
