package solved.bronze.B4;
import java.io.*;

public class B4_25640 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N --> 0) {
            if(answer.equals(br.readLine()))
                count++;
        }
        System.out.println(count);
    }
}
