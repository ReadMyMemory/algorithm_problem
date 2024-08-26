package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_30979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        while(N --> 0)
            sum += Integer.parseInt(st.nextToken());
        if(T <= sum)
            System.out.println("Padaeng_i Happy");
        else
            System.out.println("Padaeng_i Cry");
    }
}
