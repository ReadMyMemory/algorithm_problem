package solved.bronze.B1;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//새로 만든 수열을 어디에 저장하고 사용할지에 대해 조금 고민했던 것 같다.

public class B1_1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(),",");
        ArrayList<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens())
            list.add(Integer.parseInt(st.nextToken()));

        for(int i = 1; i <= K; i++) {
            for(int j = 0; j < N - i; j++) // 새로운 수열을 일단 기존의 수열 뒤에 추가한 뒤
                list.add(list.get(j+1) - list.get(j));
            if (N - i >= 0) // 기존의 수열을 제거.
                list.subList(0, N - i + 1).clear();
        }

        for(int k = 0; k < list.size(); k++) {
            bw.write(String.valueOf(list.get(k)));
            if(k != list.size() - 1)
                bw.write(",");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
