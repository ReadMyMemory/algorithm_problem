package solved.bronze.B4;
import java.io.*;

public class B4_5358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(correctName(line));
            bw.newLine();
        }
        bw.flush();
    }

    private static String correctName(String name) {
        return name.replace('i', 'X').replace('e', 'i').replace('X', 'e')
                .replace('I', 'X').replace('E', 'I').replace('X', 'E');
    }
}
