package solved.bronze;
import java.io.*;
import java.util.StringTokenizer;

public class B3_1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());
        int standard = 1; // 초기엔 1번 컵에 공이 있음.
        while(count --> 0) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            if(temp1 == standard)
                standard = temp2;
            else if(temp2 == standard)
                standard = temp1;
        }
        System.out.println(standard);
    }
}
