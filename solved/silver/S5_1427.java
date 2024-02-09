package solved.silver;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class S5_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++)
            list.add(str.charAt(i)-'0'); // 각 자리의 숫자만 리스트에 저장
        list.sort(Collections.reverseOrder()); // 내림차순 정렬
        for(int a : list) // 향상된 for문. 순차적 출력
            bw.write(String.valueOf(a));
        bw.flush();
        br.close();
        bw.close();
    }
}
