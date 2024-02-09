package solved.silver;
import java.io.*;

public class S5_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int count = 0;
        for(int i = 0; i < len; i++) {
            String temp = String.valueOf(str.charAt(i));

            // 1. c= 또는 c-
            if(temp.equals("c")) {
                if(len > i+1) { // = 또는 -가 있는지를 확인하려고 하는데, 문장의 길이를 벗어나는 경우엔 안됨.
                    String s_next = String.valueOf(str.charAt(i + 1));
                    if (s_next.equals("=") || s_next.equals("-")) {
                        count++; // 크로아티아 알파벳 하나 세고
                        i++; // 2개 읽었으니 i 하나 늘려서 패스하고
                        continue;
                    }
                }
            }

            // 2. dz= 또는 d-
            if(temp.equals("d")) {
                if(len > i+1) {
                    String s_next = String.valueOf(str.charAt(i + 1));
                     if(s_next.equals("-")) {
                         count++;
                         i++;
                         continue;
                     }
                     if(s_next.equals("z")) {
                         if(len > i+2) {
                             String s_next2 = String.valueOf(str.charAt(i + 2));
                             if(s_next2.equals("=")) {
                                 count ++;
                                 i += 2; // 여긴 3개 읽었으니 index 2번 더해줘야 한다.
                                 continue;
                             }

                         }
                     }
                }
            }

            //3. lj, nj, s=, z=
            if(len > i+1) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(str.charAt(i))).append(String.valueOf(str.charAt(i+1)));
                String s = sb.toString();
                if(s.equals("lj") || s.equals("nj") || s.equals("s=") || s.equals("z=")) {
                    count++;
                    i++;
                    continue;
                }
            }

            //4. 그냥 알파벳
            count++;
        }
        System.out.println(count);
    }
}
