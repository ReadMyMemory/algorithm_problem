package solved.bronze.B1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B1_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] files = new String[N];

        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        int len = files[0].length();
        StringBuilder pattern = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char ch = files[0].charAt(i);
            boolean isSame = true;
            for (int j = 1; j < N; j++) {
                if (files[j].charAt(i) != ch) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                pattern.append(ch);
            } else {
                pattern.append('?');
            }
        }

        System.out.println(pattern.toString());
    }
}
