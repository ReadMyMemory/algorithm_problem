package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

/*
문제에 주어진 방법으로 모든 책을 박스에 넣을 수 있는 경우만 입력으로 주어진다. 라는 조건 때문에, 매우 쉬운 문제가 되었다.
단순히 박스의 총 무게와 책의 총 무게를 뺀 것이 답이 되는 것이다.
 */

public class B2_1434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int box_limit = 0;
        int book_limit = 0;

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            box_limit += Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            book_limit += Integer.parseInt(st.nextToken());

        System.out.println(box_limit - book_limit);
    }
}
