package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_31962 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int answer = -1;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            if(X >= S + T) {
                if(answer < S)
                    answer = S;
            }
        }
        System.out.println(answer);
    }
}
