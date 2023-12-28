package solved_ac_step.class3;
import java.io.*;
import java.util.*;


public class S4_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> map = new HashSet<>();
        for(int i = 0; i < n; i++) {
            map.add(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            String str = br.readLine();
            if(map.contains(str)) { // 검색 속도가 매우 빠른 해시 알고리즘 이용
                count++;
                list.add(str);
            }
        }
        Collections.sort(list); // 사전순출력위함
        System.out.println(count);
        for(String s : list)
            bw.write(s+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
