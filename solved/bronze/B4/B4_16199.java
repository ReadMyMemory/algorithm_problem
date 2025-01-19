package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_16199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int birth_year = Integer.parseInt(st.nextToken());
        int birth_day = Integer.parseInt(st.nextToken()) * 30 + Integer.parseInt(st.nextToken()); // 단순히 큰지만 비교하면 되니까 일수로 합친다.
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int standard_year = Integer.parseInt(st1.nextToken());
        int standard_day = Integer.parseInt(st1.nextToken()) * 30 + Integer.parseInt(st1.nextToken());

        int year_diff = standard_year - birth_year;
        if(birth_day <= standard_day)
            bw.write(year_diff + "\n");
        else
            bw.write(year_diff - 1 + "\n");
        bw.write(year_diff + 1 + "\n");
        bw.write(year_diff + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
