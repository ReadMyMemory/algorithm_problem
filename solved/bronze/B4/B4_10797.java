package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int count = 0;
        while(st.hasMoreTokens()) {
            if(number == Integer.parseInt(st.nextToken()))
                count++;
        }

        System.out.println(count);
    }
}
