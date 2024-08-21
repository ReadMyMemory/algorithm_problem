package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_26068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), "-"); // delim으로 -를 사용
            st.nextToken(); // D는 필요 없으니 버린다.
            if(90 >= Integer.parseInt(st.nextToken()))
                count++;
        }
        System.out.println(count);
    }
}
