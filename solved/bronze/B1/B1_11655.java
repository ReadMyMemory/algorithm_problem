package solved.bronze.B1;
import java.io.*;

public class B1_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                sb.append((char) ((c - 'A' + 13) % 26 + 'A'));
            } else if ('a' <= c && c <= 'z') {
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            } else {
                sb.append(c); // 알파벳이 아니면 그대로
            }
        }
        System.out.println(sb);
    }
}