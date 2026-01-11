package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_1924 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] dayName = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        int total = 0;

        for (int i = 0; i < m - 1; i++) {
            total += daysInMonth[i];
        }

        total += (d - 1);

        System.out.println(dayName[total % 7]);
    }
}
