package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

/*
T가 1,2,3,4중 주어지고, 이거랑 같은 값이 주어진 경우를 count 하라는거다.
 */
public class B4_11549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = 5;
        int count = 0;
        while (p --> 0) {
            if(T == Integer.parseInt(st.nextToken()))
                count++;
        }
        System.out.println(count);
    }
}
