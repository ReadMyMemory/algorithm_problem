package solved_ac_step.class1;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());


        while(testNum > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = new ArrayList<>(); // 문자 한글자씩 끊어서 리스트에 저장.
            int repeat = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for(int i = 0; i < str.length(); i++) {
                list.add(String.valueOf(str.charAt(i))); // 한글자씩 끊어서 리스트에 저장.
            }
            for(int i =0; i < str.length(); i++) {
                for (int j = 0; j < repeat; j++) {
                    sb.append(list.get(i)); // stringbuilder로 한문자 repeat횟수만큼 붙이고, 그걸 문장 길이만큼 반복.
                }
            }
            bw.write(sb.toString()+"\n");
            testNum--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
