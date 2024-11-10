package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int idx = 0;
        int count = 0;
        while (true) {
            boolean isSkip = false;
            idx++;
            String s = String.valueOf(idx);
            for (int j = 0; j < s.length(); j++) {
                if (L == s.charAt(j) - '0')
                    isSkip = true;
            }
            if(isSkip)
                continue;
            count++;
            if (N == count)
                break;
        }
        System.out.println(idx);
    }
}
