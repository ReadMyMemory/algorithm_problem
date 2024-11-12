package solved.silver.S5;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S5_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] name = new String[N];
        int[][] birth = new int[N][3];
        int idx = 0;
        int max_idx = -1; // 생일 값이 젤 큰 사람 = 나이가 젤 어린 사람
        int max_year = 0;
        int max_month = 0;
        int max_day = 0;
        int min_idx = -1; // 생일 값이 젤 작은 사람 = 나이가 젤 많은 사람
        int min_year = 9999;
        int min_month = 99;
        int min_day = 99;

        //입력부
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            name[idx] = st.nextToken();
            for(int i = 0; i < 3; i++)
                birth[idx][i] = Integer.parseInt(st.nextToken());
            idx++;
        }

        //계산부
        for(int i = 0; i < name.length; i++) {

            // 생일 값이 젤 큰 사람 체크
            if(max_year < birth[i][2]) { // year 체크
                max_idx = i; // year가 더 크면 연, 월, 일 갱신
                max_year = birth[i][2];
                max_month = birth[i][1];
                max_day = birth[i][0];
            } else if (max_year == birth[i][2]) { // year이 같다면
                    if (max_month < birth[i][1]) { // month 체크
                        max_idx = i; // month가 더 크면 월, 일 갱신
                        max_month = birth[i][1];
                        max_day = birth[i][0];
                    } else if (max_month == birth[i][1]) {// month도 같다면
                        if(max_day < birth[i][0]) {// day 비교
                            max_idx = i; // day가 더 크면 일 갱신
                            max_day = birth[i][0];
                        }
                    }
            }

            // 생일 젤 작은 사람 체크
            if(min_year > birth[i][2]) { // year 체크
                min_idx = i; // year가 더 작으면 연, 월, 일 갱신
                min_year = birth[i][2];
                min_month = birth[i][1];
                min_day = birth[i][0];
            } else if (min_year == birth[i][2]) { // year이 같다면
                if (min_month > birth[i][1]) { // month 체크
                    min_idx = i; // month가 더 작으면 월, 일 갱신
                    min_month = birth[i][1];
                    min_day = birth[i][0];
                } else if (min_month == birth[i][1]) {// month도 같다면
                    if(min_day > birth[i][0]) {// day 비교
                        min_idx = i; // day가 더 작으면 일 갱신
                        min_day = birth[i][0];
                    }
                }
            }
        }

        System.out.println(name[max_idx]); // 생일 값이 젤 큰 사람 = 나이가 젤 어린 사람
        System.out.println(name[min_idx]); // 생일 값이 젤 작은 사람 = 나이가 젤 많은 사람
    }
}
