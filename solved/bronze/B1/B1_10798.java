package solved.bronze.B1;
import java.io.*;

public class B1_10798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = new String[5];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
            maxLen = Math.max(maxLen, arr[i].length());
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < maxLen; j++) {
            for (int i = 0; i < 5; i++) {
                if (j < arr[i].length()) {
                    sb.append(arr[i].charAt(j));
                }
            }
        }
        System.out.print(sb);
    }
}