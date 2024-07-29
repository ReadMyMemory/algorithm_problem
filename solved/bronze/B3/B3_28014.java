package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_28014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int standard = Integer.parseInt(st.nextToken());
        int count = 1;
        while (N --> 1) {
            int temp = Integer.parseInt(st.nextToken());
            if(standard <= temp)
                count++;
            standard = temp;
        }
        System.out.println(count);
    }
}
