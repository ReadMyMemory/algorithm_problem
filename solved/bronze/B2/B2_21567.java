package solved.bronze.B2;
import java.io.*;

public class B2_21567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = Long.parseLong(br.readLine()) * Long.parseLong(br.readLine()) * Long.parseLong(br.readLine());
        int[] count = new int[10];
        String s = String.valueOf(sum);
        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i) - '0']++;
        for(int a : count)
            System.out.println(a);
    }
}
