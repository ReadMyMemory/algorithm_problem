package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_29614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 등급별 학점 매핑
        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D", 1.0);
        gradeMap.put("F", 0.0);

        List<Double> scores = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // + 가 있는 등급 먼저 확인 (두 글자)
            if (i + 1 < s.length() && s.charAt(i + 1) == '+') {
                String grade = s.substring(i, i + 2);
                scores.add(gradeMap.get(grade));
                i += 2;
            }
            // 한 글자 등급
            else {
                String grade = s.substring(i, i + 1);
                scores.add(gradeMap.get(grade));
                i++;
            }
        }

        // 평균 계산
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        double average = sum / scores.size();
        System.out.println(average);
    }
}