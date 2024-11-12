package solved.silver.S4;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/* 이거 12873 기념품 문제랑 비슷하더라 */
public class S4_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> print = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++)
            list.add(i);
        int index = 0;
        bw.write("<");
        for(int i = 0; i < N; i++) {
            int temp = (index + K) % list.size() - 1;
            if(temp < 0)
                temp += list.size();
            index=temp;
            if(i == N-1)
                bw.write(list.get(index)+">");
            else
                bw.write(list.get(index)+", ");
            list.remove(index);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
