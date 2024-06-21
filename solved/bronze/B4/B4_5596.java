package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int S = 0;
        S += Integer.parseInt(st.nextToken());
        S += Integer.parseInt(st.nextToken());
        S += Integer.parseInt(st.nextToken());
        S += Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int T = 0;
        T += Integer.parseInt(st.nextToken());
        T += Integer.parseInt(st.nextToken());
        T += Integer.parseInt(st.nextToken());
        T += Integer.parseInt(st.nextToken());

        System.out.println(Math.max(S, T));

    }
}
