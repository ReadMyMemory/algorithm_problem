package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_13915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            Set<String> categories = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String flights = br.readLine().trim();
                Set<Character> uniqueBalloons = new TreeSet<>();

                for (char c : flights.toCharArray()) {
                    uniqueBalloons.add(c);
                }

                // 정렬된 문자들을 하나의 문자열로 변환
                StringBuilder sb = new StringBuilder();
                for (char c : uniqueBalloons) {
                    sb.append(c);
                }
                categories.add(sb.toString());
            }

            System.out.println(categories.size());
        }
    }
}
