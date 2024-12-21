package solved.bronze.B2;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B2_32621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean status = true;
        StringTokenizer st = new StringTokenizer(br.readLine(), "+");
        int count = st.countTokens();
        if(count != 2) {
            System.out.println("No Money");
            status = false;
        } else {
            Set<String> set = new HashSet<>();
            String str = "";

            for(int i = 0; i < count; i++) {
                str = st.nextToken();
                set.add(str);
            }

            if(set.size() != 1 || str.charAt(0) == '0') {
                System.out.println("No Money");
                status = false;
            } else {
                for(char c : str.toCharArray()) {
                    if(!Character.isDigit(c)) {
                        System.out.println("No Money");
                        status = false;
                        break;
                    }
                }
            }
        }

        if(status)
            System.out.println("CUTE");
    }
}
