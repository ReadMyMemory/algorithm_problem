package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_30402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = 15;

        //label을 써도 되고, 그냥 if 조건 성립하면 N을 0으로 만들어도 될 것 같다.
        outerLoop:
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                char c = st.nextToken().charAt(0);
                if(c == 'w') {
                    bw.write("chunbae");
                    break outerLoop;
                }
                if(c == 'b') {
                    bw.write("nabi");
                    break outerLoop;
                }
                if(c == 'g') {
                    bw.write("yeongcheol");
                    break outerLoop;
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
