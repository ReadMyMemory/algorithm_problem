package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_4374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        boolean firstCase = true;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());

            // 단어 빈도 계산
            Map<String, Integer> wordCount = new HashMap<>();

            while ((line = br.readLine()) != null) {
                if (line.trim().equals("EndOfText")) {
                    break;
                }

                // 문자가 아닌 것을 기준으로 분리
                StringBuilder word = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (Character.isLetter(ch)) {
                        word.append(Character.toLowerCase(ch));
                    } else {
                        if (word.length() > 0) {
                            String w = word.toString();
                            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
                            word = new StringBuilder();
                        }
                    }
                }
                // 마지막 단어 처리
                if (word.length() > 0) {
                    String w = word.toString();
                    wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
                }
            }

            // n번 등장하는 단어 찾기
            List<String> result = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                if (entry.getValue() == n) {
                    result.add(entry.getKey());
                }
            }

            // 테스트 케이스 구분을 위한 빈 줄
            if (!firstCase) {
                sb.append("\n");
            }
            firstCase = false;

            // 결과 출력
            if (result.isEmpty()) {
                sb.append("There is no such word.\n");
            } else {
                Collections.sort(result);
                for (String word : result) {
                    sb.append(word).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}