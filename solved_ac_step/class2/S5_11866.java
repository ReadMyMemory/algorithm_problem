package solved_ac_step.class2;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S5_11866 {
    static int now;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> print = new ArrayList<>();
        for(int i = 1; i <= N; i++)
            list.add(i);
        int index = K;
        now = 0;
        while(list.size() != 0) {
            int temp = now + index - 1;
            while(temp >= list.size()) { //now(이전에 삭제한 인덱스) + K 만큼 이동했을 때 전체 인원 수 넘어가면, 루프 도는 거니까 그만큼 빼줌.
                temp -= list.size();
            }
            print.add(list.get(temp));
//            System.out.print("temp : "+temp);
//            System.out.print(" 제거되는 값 : "+list.get(temp));
            list.remove(temp);
            if(temp == list.size()) // 제거한 값이 마지막 값이면, 다시 첨부터 K만큼 찾음.
                now = 0;
            else
                now = temp;
//            System.out.println(" 다음 시작 인덱스 : "+now);
        }

        bw.write("<");
        for(int i = 0; i < N-1; i++) {
            bw.write(print.get(i)+", ");
        }
        bw.write(print.get(N-1)+">");
        bw.flush();
        br.close();
        bw.close();
    }
}
