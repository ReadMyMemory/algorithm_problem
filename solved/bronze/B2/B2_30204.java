package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_30204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        while(N --> 0)
            sum += Integer.parseInt(st.nextToken());
        if(sum % X == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
