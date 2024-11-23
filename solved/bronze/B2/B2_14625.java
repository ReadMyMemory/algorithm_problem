package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_14625 {

    private static boolean canSee(int a, int n) {
        if (a<1000 && n==0) return true;
        while (a!=0) {
            if (a%10==n) return true;
            a/=10;
        }
        return false;
    }
    private static int plusMin(int a) {
        if (a%100 == 59)
            return (a/100+1)*100;
        return ++a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startTime = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken()); // ex 1520
        st = new StringTokenizer(br.readLine());
        int endTime = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken()); // ex 160
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (startTime<=endTime) {
            if (canSee(startTime, n)) cnt++;
            startTime = plusMin(startTime);
        }
        System.out.println(cnt);
    }
}
