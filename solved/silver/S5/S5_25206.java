package solved.silver.S5;
import java.io.*;
import java.util.StringTokenizer;

public class S5_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double grade_total = 0; // 학점 x 과목평점
        double grade_sum = 0; // 학점 총합
        char c;

        for(int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            double point = Double.parseDouble(st.nextToken()); // 학점
            double grade = 0; // 등급 점수
            String temp = st.nextToken();
            c = temp.charAt(0);

            switch(c) {
                case 'A':
                    if(temp.charAt(1) == '+')
                        grade += 4.5;
                    else
                        grade += 4.0;
                    break;
                case 'B':
                    if(temp.charAt(1) == '+')
                        grade += 3.5;
                    else
                        grade += 3.0;
                    break;
                case 'C':
                    if(temp.charAt(1) == '+')
                        grade += 2.5;
                    else
                        grade += 2.0;
                    break;
                case 'D':
                    if(temp.charAt(1) == '+')
                        grade += 1.5;
                    else
                        grade += 1.0;
                    break;
                case 'F':
                    grade += 0;
                    break;
                case 'P':
                    grade += 0;
                    point = 0;
                    break;
            }
            grade_sum += point;
            grade_total += point * grade;
        }
        System.out.println(grade_total / grade_sum);

    }
}
