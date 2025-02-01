package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;
/*
운영체제 시간에 배웠던 프로세스 스케쥴링을 다시금 기억하게 되는..
 */


public class B3_10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int work = 0;
        int count = 0;
        st = new StringTokenizer(br.readLine());
        br.close();
        while(n --> 0) {
            work += Integer.parseInt(st.nextToken());
            if(work <= T)
                count++;
            else
                break;
        }
        System.out.println(count);

    }
}
